package ru.fly.examples.client.textfield;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.fly.client.Loader;
import ru.fly.client.ui.field.TextField;
import ru.fly.client.ui.field.VariantTextField;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.panel.Margin;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.panel.VLayout;
import ru.fly.client.ui.panel.fieldset.FieldSetPanel;
import ru.fly.examples.client.LocalDataSource;
import ru.fly.shared.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author fil.
 */
public class TextFieldSample extends FlowLayout {

    public TextFieldSample() {
        FieldSetPanel fset = new FieldSetPanel("Simple TextField");
        fset.setPixelSize(200, 60);
        VLayout vLayout = new VLayout();
        vLayout.add(new TextField(), new VHLayoutData(1, -1));
        fset.add(vLayout, new Margin(5));
        add(fset);

        fset = new FieldSetPanel("VariantTextField");
        fset.setPixelSize(200, 60);
        vLayout = new VLayout();
        Getter<String> getter = new Getter<String>() {
            @Override
            public String get(String model) {
                return model == null ? "" : model;
            }
        };
        VariantTextField<String> variantTextField = new VariantTextField<>(getter, getter);
        variantTextField.setLoader(new Loader<String, Collection<String>>() {
            @Override
            public void load(String config, AsyncCallback<Collection<String>> cback) {
                List<String> ret = new ArrayList<>();
                if (config == null || config.isEmpty()) {
                    ret.addAll(LocalDataSource.digits);
                } else {
                    for (String d : LocalDataSource.digits) {
                        if (d.contains(config.toLowerCase())) {
                            ret.add(d);
                        }
                    }
                }
                cback.onSuccess(ret);
            }
        });
        vLayout.add(variantTextField, new VHLayoutData(1, -1));
        fset.add(vLayout, new Margin(5));
        add(fset);
    }

}
