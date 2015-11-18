package ru.fly.examples.client.date;

import ru.fly.client.ui.field.datefield.DateField;
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
        FieldSetPanel dateFieldSet = new FieldSetPanel("Date field");
        add(dateFieldSet, new VHLayoutData(200, 60));
        FlowLayout dateFieldLayout = new FlowLayout();
        dateFieldSet.add(dateFieldLayout);
        DateField dateField = new DateField();
        dateFieldLayout.add(dateField.withWidth(80), new Margin(4));

        FieldSetPanel datePickerSet = new FieldSetPanel("Date picker");
        add(datePickerSet, new VHLayoutData(200, 60));
        FlowLayout datePickerLayout = new FlowLayout();
        datePickerSet.add(datePickerLayout);
        DatePickerField datePicker = new DatePickerField();
        datePickerLayout.add(datePicker, new Margin(4));

        FieldSetPanel datePickerSelSet = new FieldSetPanel("Date picker (select only)");
        add(datePickerSelSet, new VHLayoutData(200, 60));
        FlowLayout datePickerSelLayout = new FlowLayout();
        datePickerSelSet.add(datePickerSelLayout);
        DatePickerField datePickerSel = new DatePickerField();
        datePickerSel.setEditable(false);
        datePickerSelLayout.add(datePickerSel, new Margin(4));

        FieldSetPanel monthSet = new FieldSetPanel("Month picker");
        add(monthSet, new VHLayoutData(200, 60));
        FlowLayout monthLayout = new FlowLayout();
        monthSet.add(monthLayout);
        MonthPickerField monthPicker = new MonthPickerField();
        monthLayout.add(monthPicker, new Margin(4));
    }

}
