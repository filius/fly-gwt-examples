package ru.fly.examples.client;

import ru.fly.client.event.SelectEvent;
import ru.fly.client.ui.panel.ContentPanel;
import ru.fly.client.ui.panel.HLayout;
import ru.fly.client.ui.panel.Margin;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.panel.messagebox.MessageBox;
import ru.fly.client.ui.tree.Tree;
import ru.fly.client.ui.tree.TreeGetter;
import ru.fly.examples.client.tree.TreeGridSample;
import ru.fly.shared.Getter;

/**
 * User: fil
 * Date: 05.03.15
 */
public class MainPanel extends HLayout {

    private Tree<TreeItem> navMenu;
    private ContentPanel container;

    public MainPanel(){
        ContentPanel widgetsPanel = new ContentPanel("Widgets");
        add(widgetsPanel, new VHLayoutData(260, 1, new Margin(4)));
        navMenu = new Tree<>(new TreeGetter<TreeItem>() {
            @Override
            public String get(TreeItem model) {
                return model.getName();
            }

            @Override
            public boolean isFolder(TreeItem model) {
                return model instanceof TreeFolder;
            }
        });
        widgetsPanel.add(navMenu);
        navMenu.addSelectHandler(new SelectEvent.SelectHandler<TreeItem>() {
            @Override
            public void onSelect(TreeItem object) {
                doSelect(object);
            }
        });

        container = new ContentPanel("Widget example");
        add(container, new VHLayoutData(1,1, new Margin(4,4,4,0)));

        initItems();
    }

    private void initItems(){
        TreeFolder treeItem = new TreeFolder("Trees");
        navMenu.getStore().add(null, treeItem);
        navMenu.getStore().add(treeItem, new TreeItem("TreeGrid", "tree_grid"));
    }

    private void doSelect(TreeItem item){
        Margin m = new Margin(10);
        if("tree_grid".equals(item.getSign())){
            container.add(new TreeGridSample(), m);
        }
    }

}
