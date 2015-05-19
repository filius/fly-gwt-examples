package ru.fly.examples.client.combobox;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.fly.client.Loader;
import ru.fly.client.ui.field.combobox.ComboBox;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.shared.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * User: fil
 * Date: 10.05.15
 */
public class ComboBoxSample extends FlowLayout {

    public ComboBoxSample(){
        ComboBox<String> box = new ComboBox<String>(new Getter<String>() {
            @Override
            public String get(String model) {
                return model == null ? "" : model;
            }
        });
        box.setHasEmpty(true);
        box.setAlwaysLoad(true);
        box.setLoader(new Loader<String, List<String>>() {
            @Override
            public void load(String config, AsyncCallback<List<String>> cback) {
                cback.onSuccess(Arrays.asList("One","Two","Three"));
            }
        });
        box.setValue("Two");
        add(box);
    }

}
