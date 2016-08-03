package ru.fly.examples.client.tree;

import ru.fly.client.event.ClickEvent;
import ru.fly.client.ui.button.Button;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.tree.LazyTreeView;
import ru.fly.client.ui.tree.Tree;
import ru.fly.client.ui.tree.TreeGetter;

/**
 * @author fil
 */
public class LazyTreeSample extends FlowLayout {

    private final Tree<TreeItem> tree;

    public LazyTreeSample() {
        FlowLayout buttonsPanel = new FlowLayout();
        add(buttonsPanel);
        buttonsPanel.add(new Button("Expand all", new ClickEvent.ClickHandler() {
            @Override
            public void onClick() {
                tree.expandAll();
            }
        }));
        buttonsPanel.add(new Button("Expand all and select \"item2_2\"", new ClickEvent.ClickHandler() {
            @Override
            public void onClick() {
                tree.expandAll();
                tree.select(new TreeItem("item2_2", null));
            }
        }));

        tree = new Tree<TreeItem>(new TreeGetter<TreeItem>() {
            @Override
            public boolean isFolder(TreeItem model) {
                return model instanceof TreeFolder;
            }

            @Override
            public String get(TreeItem model) {
                return model.getName();
            }
        });
        tree.setView(new LazyTreeView<TreeItem>());
        tree.setPixelSize(200, 400);
        add(tree);
        for (int i = 1; i <= 100; i++) {
            TreeFolder folder = new TreeFolder("folder" + i);
            tree.getStore().add(null, folder);
            for (int j = 1; j <= i; j++) {
                String name = "item" + i + "_" + j;
                tree.getStore().add(folder, new TreeItem(name, name));
            }
        }
    }

}
