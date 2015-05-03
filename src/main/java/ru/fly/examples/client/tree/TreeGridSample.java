package ru.fly.examples.client.tree;

import ru.fly.client.ui.grid.ColumnConfig;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.tree.TreeGetter;
import ru.fly.client.ui.tree.TreeGrid;
import ru.fly.shared.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * User: fil
 * Date: 03.05.15
 */
public class TreeGridSample extends FlowLayout {

    public TreeGridSample(){
        List<ColumnConfig<TreeGridItem>> cols = Arrays.asList(
                new ColumnConfig<TreeGridItem>(new Getter<TreeGridItem>() {
                    @Override
                    public String get(TreeGridItem model) {
                        return model.getColumn1();
                    }
                }, "Column 1"),
                new ColumnConfig<TreeGridItem>(new Getter<TreeGridItem>() {
                    @Override
                    public String get(TreeGridItem model) {
                        return model.getColumn2();
                    }
                }, "Column 2", 60),
                new ColumnConfig<TreeGridItem>(new Getter<TreeGridItem>() {
                    @Override
                    public String get(TreeGridItem model) {
                        return model.getColumn3();
                    }
                }, "Column 3", 60)
        );

        TreeGrid<TreeGridItem> treeGrid = new TreeGrid<>(new TreeGetter<TreeGridItem>() {
            @Override
            public String get(TreeGridItem model) {
                return null;
            }

            @Override
            public boolean isFolder(TreeGridItem model) {
                return model instanceof TreeGridFolder;
            }
        }, cols);
        treeGrid.setPixelSize(400, 400);
        add(treeGrid);
        TreeGridFolder folder1 = new TreeGridFolder("folder1");
        treeGrid.getStore().add(null, folder1);
        treeGrid.getStore().add(folder1, new TreeGridItem("item1_1_1", "item1_1_2", "item1_1_3"));
        treeGrid.getStore().add(folder1, new TreeGridItem("item1_2_1", "item1_2_2", "item1_2_3"));
        treeGrid.getStore().add(folder1, new TreeGridItem("item1_3_1", "item1_3_2", "item1_3_3"));
        TreeGridFolder folder2 = new TreeGridFolder("folder2");
        treeGrid.getStore().add(null, folder2);
        treeGrid.getStore().add(folder2, new TreeGridItem("item2_1_1", "item2_1_2", "item2_1_3"));
        treeGrid.getStore().add(folder2, new TreeGridItem("item2_2_1", "item2_2_2", "item2_2_3"));
        treeGrid.getStore().add(folder2, new TreeGridItem("item2_3_1", "item2_3_2", "item2_3_3"));
    }

}
