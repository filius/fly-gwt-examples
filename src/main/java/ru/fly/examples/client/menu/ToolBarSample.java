package ru.fly.examples.client.menu;

import ru.fly.client.event.ClickEvent;
import ru.fly.client.ui.button.MenuButton;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.toolbar.Menu;
import ru.fly.client.ui.toolbar.MenuItem;
import ru.fly.client.ui.toolbar.ToolBar;
import ru.fly.client.ui.toolbar.ToolbarSplitter;

/**
 * User: fil
 * Date: 10.05.15
 */
public class ToolBarSample extends FlowLayout {

    public ToolBarSample(){
        ToolBar toolBar = new ToolBar();
        add(toolBar);

        Menu menu1 = new Menu();
        menu1.add(getSubItem("SubItem1"));
        menu1.add(getSubItem("SubItem2"));
        menu1.add(getSubItem("SubItem3"));
        toolBar.add(new MenuButton("item1", menu1));
        toolBar.add(new ToolbarSplitter());

        Menu menu2 = new Menu();
        menu2.add(getSubItem("1"));
        menu2.add(getSubItem("2"));
        menu2.add(getSubItem("3"));
        toolBar.add(new MenuButton("item2", menu2));
    }

    private MenuItem getSubItem(String text){
        return new MenuItem(text, new ClickEvent.ClickHandler() {
            @Override
            public void onClick() {

            }
        });
    }

}
