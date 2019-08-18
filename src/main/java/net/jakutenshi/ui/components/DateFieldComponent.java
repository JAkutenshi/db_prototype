package net.jakutenshi.ui.components;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import com.toedter.calendar.JTextFieldDateEditor;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXMonthView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import static net.jakutenshi.utils.Constants.*;

public class DateFieldComponent extends JComponent {
    private JDatePickerImpl datePicker;
    private final boolean isReadOnly;


    public DateFieldComponent(String description, boolean isReadOnly) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(description));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_TERMINUS_BOLD);

        this.isReadOnly = isReadOnly;


        JXDatePicker dp = new JXDatePicker(new Date(), new Locale("ru"));
        dp.setFormats(DATE_FORMAT);
        dp.setSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
        dp.setLinkPanel(null);

        SpinnerModel model = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(model);
        JComponent editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(editor);
        timeSpinner.setValue(new Date());

        JDateChooser c = new JDateChooser(new JCalendar(new Locale("ru")), new Date(), DATE_FORMAT.toPattern(), new JTextFieldDateEditor());
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));

        JTextFieldDateEditor t = new JTextFieldDateEditor(TIME_FORMAT.toPattern(), "11:12", '0');
        this.add(t);
    }
}
