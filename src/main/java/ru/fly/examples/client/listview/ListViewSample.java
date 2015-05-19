package ru.fly.examples.client.listview;

import ru.fly.client.ui.listview.ListView;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.shared.Getter;

import java.util.Arrays;

/**
 * User: fil
 * Date: 10.05.15
 */
public class ListViewSample extends FlowLayout {

    public ListViewSample(){
        ListView<String> listView = new ListView<String>(new Getter<String>() {
            @Override
            public String get(String model) {
                return model == null ? "" : model;
            }
        });
        listView.setWidth(300);
        listView.fillData(Arrays.asList("One","Two","Three"), false);
        listView.select("Two");
        add(listView);
    }

}
