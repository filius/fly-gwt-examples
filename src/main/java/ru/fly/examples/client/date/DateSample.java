package ru.fly.examples.client.date;

import ru.fly.client.ui.field.datefield.DatePickerField;
import ru.fly.client.ui.field.datefield.MonthPickerField;
import ru.fly.client.ui.panel.FlowLayout;
import ru.fly.client.ui.panel.Margin;
import ru.fly.client.ui.panel.VHLayoutData;
import ru.fly.client.ui.panel.VLayout;
import ru.fly.client.ui.panel.fieldset.FieldSetPanel;

/**
 * User: fil
 * Date: 18.10.15
 */
public class DateSample extends VLayout {

    public DateSample(){
        FieldSetPanel dateSet = new FieldSetPanel("Date picker");
        add(dateSet, new VHLayoutData(200, 60));
        FlowLayout dateLayout = new FlowLayout();
        dateSet.add(dateLayout);
        DatePickerField datePicker = new DatePickerField();
        dateLayout.add(datePicker, new Margin(4));

        FieldSetPanel monthSet = new FieldSetPanel("Month picker");
        add(monthSet, new VHLayoutData(200, 60));
        FlowLayout monthLayout = new FlowLayout();
        monthSet.add(monthLayout);
        MonthPickerField monthPicker = new MonthPickerField();
        monthLayout.add(monthPicker, new Margin(4));
    }

}
