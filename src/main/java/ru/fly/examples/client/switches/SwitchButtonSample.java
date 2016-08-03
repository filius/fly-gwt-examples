package ru.fly.examples.client.switches;

import ru.fly.client.ui.field.label.FieldLabel;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.field.switches.SwitchButtonField;

/**
 * User: fil
 * Date: 05.12.15
 */
public class SwitchButtonSample extends FlowLayout {

    public SwitchButtonSample(){
        add(new FieldLabel(new SwitchButtonField(), "With NULL value", 120));
        SwitchButtonField trueSwitch = new SwitchButtonField();
        trueSwitch.setValue(true);
        add(new FieldLabel(trueSwitch, "With TRUE value", 120));
        SwitchButtonField falseSwitch = new SwitchButtonField();
        falseSwitch.setValue(false);
        add(new FieldLabel(falseSwitch, "With FALSE value", 120));
    }

}
