package ru.fly.examples.client;

import ru.fly.client.event.SelectEvent;
import ru.fly.client.ui.panel.ContentPanel;
import ru.fly.client.ui.panel.HLayout;
import ru.fly.client.ui.panel.Margin;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.tree.Tree;
import ru.fly.client.ui.tree.TreeGetter;
import ru.fly.examples.client.combobox.ComboBoxSample;
import ru.fly.examples.client.date.DateSample;
import ru.fly.examples.client.listview.ListViewSample;
import ru.fly.examples.client.menu.ToolBarSample;
import ru.fly.examples.client.switches.SwitchButtonSample;
import ru.fly.examples.client.textfield.TextFieldSample;
import ru.fly.examples.client.tree.LazyTreeSample;
import ru.fly.examples.client.tree.TreeFolder;
import ru.fly.examples.client.tree.TreeGridSample;
import ru.fly.examples.client.tree.TreeItem;
import ru.fly.examples.client.tree.TreeSample;

import java.util.List;

/**
 * @author fil
 */
public class MainPanel extends HLayout {

    private Tree<TreeItem> navMenu;
    private ContentPanel container;

    public MainPanel() {
        ContentPanel widgetsPanel = new ContentPanel("Widgets");
        add(widgetsPanel, new VHLayoutData(260, 1, new Margin(4)));
        navMenu = new Tree<>(new TreeGetter<TreeItem>() {
            @Override
            public String get(TreeItem model) {
                return model == null ? "" : model.getName();
            }

            @Override
            public boolean isFolder(TreeItem model) {
                return model instanceof TreeFolder;
            }

            @Override
            public List<? extends TreeItem> getChildren(TreeItem model) {
                return null;
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
        add(container, new VHLayoutData(1, 1, new Margin(4, 4, 4, 0)));

        initItems();
    }

    private void initItems() {
        TreeFolder textItem = new TreeFolder("TextField");
        navMenu.getStore().add(null, textItem);
        navMenu.getStore().add(textItem, new TreeItem("TextField", "text_field"));

        TreeFolder treeItem = new TreeFolder("Trees");
        navMenu.getStore().add(null, treeItem);
        navMenu.getStore().add(treeItem, new TreeItem("Tree", "tree"));
//        navMenu.getStore().add(treeItem, new TreeItem("Tree (LazyTreeView)", "lazy_tree"));
        navMenu.getStore().add(treeItem, new TreeItem("TreeGrid", "tree_grid"));

        TreeFolder comboBoxItem = new TreeFolder("ComboBox");
        navMenu.getStore().add(null, comboBoxItem);
        navMenu.getStore().add(comboBoxItem, new TreeItem("Simple ComboBox", "combo_box"));

        TreeFolder listViewItem = new TreeFolder("ListView");
        navMenu.getStore().add(null, listViewItem);
        navMenu.getStore().add(listViewItem, new TreeItem("Simple ListView", "list_view"));

        TreeFolder toolbarItem = new TreeFolder("ToolBar");
        navMenu.getStore().add(null, toolbarItem);
        navMenu.getStore().add(toolbarItem, new TreeItem("Simple ToolBar", "tool_bar"));

        TreeFolder dateItem = new TreeFolder("Date");
        navMenu.getStore().add(null, dateItem);
        navMenu.getStore().add(dateItem, new TreeItem("DateField's", "date"));

        TreeFolder switchItem = new TreeFolder("Switch");
        navMenu.getStore().add(null, switchItem);
        navMenu.getStore().add(switchItem, new TreeItem("Simple SwitchButton", "switch"));
    }

    private void doSelect(TreeItem item) {
        Margin m = new Margin(10);
        if ("tree".equals(item.getSign())) {
            container.add(new TreeSample(), m);
        } else if ("text_field".equals(item.getSign())) {
            container.add(new TextFieldSample(), m);
        } else if ("lazy_tree".equals(item.getSign())) {
            container.add(new LazyTreeSample(), m);
        } else if ("tree_grid".equals(item.getSign())) {
            container.add(new TreeGridSample(), m);
        } else if ("combo_box".equals(item.getSign())) {
            container.add(new ComboBoxSample(), m);
        } else if ("list_view".equals(item.getSign())) {
            container.add(new ListViewSample(), m);
        } else if ("tool_bar".equals(item.getSign())) {
            container.add(new ToolBarSample(), m);
        } else if ("date".equals(item.getSign())) {
            container.add(new DateSample(), m);
        } else if ("switch".equals(item.getSign())) {
            container.add(new SwitchButtonSample(), m);
        } else {
            container.clear();
        }
    }

}
