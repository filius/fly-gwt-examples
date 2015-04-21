package ru.fly.examples.client;

import ru.fly.client.ui.panel.HLayout;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.tree.Tree;

/**
 * User: fil
 * Date: 05.03.15
 */
public class MainPanel extends HLayout {

    public MainPanel(){
        Tree tree = new Tree();
        add(tree, new VHLayoutData(200,1));
    }

}
