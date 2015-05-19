package ru.fly.examples.client.tree;

import ru.fly.client.event.ClickEvent;
import ru.fly.client.ui.button.Button;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.tree.Tree;
import ru.fly.client.ui.tree.TreeGetter;

/**
 * User: fil
 * Date: 20.05.15
 */
public class TreeSample extends FlowLayout {

    private final Tree<TreeItem> tree;

    public TreeSample(){
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
        tree.setPixelSize(200, 400);
        add(tree);
        TreeFolder folder1 = new TreeFolder("folder1");
        tree.getStore().add(null, folder1);
        tree.getStore().add(folder1, new TreeItem("item1_1", "item1_1"));
        tree.getStore().add(folder1, new TreeItem("item1_2", "item1_2"));
        tree.getStore().add(folder1, new TreeItem("item1_3", "item1_3"));
        TreeFolder folder2 = new TreeFolder("folder2");
        tree.getStore().add(null, folder2);
        tree.getStore().add(folder2, new TreeItem("item2_1", "item2_1"));
        tree.getStore().add(folder2, new TreeItem("item2_2", "item2_2"));
        tree.getStore().add(folder2, new TreeItem("item2_3", "item2_3"));
    }

}
