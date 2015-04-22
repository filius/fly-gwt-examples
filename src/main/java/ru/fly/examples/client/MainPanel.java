package ru.fly.examples.client;

import ru.fly.client.ui.panel.HLayout;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.panel.messagebox.MessageBox;
import ru.fly.client.ui.tree.Tree;
import ru.fly.client.ui.tree.TreeGetter;
import ru.fly.shared.Getter;

/**
 * User: fil
 * Date: 05.03.15
 */
public class MainPanel extends HLayout {

    public MainPanel(){
        Tree<TreeItem> tree = new Tree<>(new TreeGetter<TreeItem>() {
            @Override
            public String get(TreeItem model) {
                return model.getName();
            }

            @Override
            public boolean isFolder(TreeItem model) {
                return model instanceof TreeFolder;
            }
        });
        add(tree, new VHLayoutData(200, 1));

        TreeFolder one = new TreeFolder("one");
        tree.getStore().add(null, one);
        tree.getStore().add(one, new TreeItem("one.one__________________width"));
        tree.getStore().add(one, new TreeItem("one.two"));
        tree.getStore().add(one, new TreeItem("one.three"));
        tree.getStore().add(null, new TreeFolder("two"));
    }

}
