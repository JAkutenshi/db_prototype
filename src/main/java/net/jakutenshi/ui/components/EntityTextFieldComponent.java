package net.jakutenshi.ui.components;

import jdk.internal.org.jline.terminal.Size;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static net.jakutenshi.utils.Constants.*;

public class EntityTextFieldComponent extends JComponent {
    private JTextField field;
    private final boolean readOnly;

    public EntityTextFieldComponent(String description, String initValue, boolean readOnly) {
        super();
        this.readOnly = readOnly;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(description));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_TERMINUS_BOLD);
        this.setSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT + 15));


        field = new JTextField();
        field.setFont(FONT_TERMINUS);
        field.setEditable(false);
        setField(initValue);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
        this.add(field);
    }

    public String getValue(){
        return field.getText();
    }

    @Override
    public String toString() {
        return getValue();
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    @Override
    public void setEnabled(boolean b) {
        if (!readOnly) {
            field.setEditable(b);
        }
    }

    /*@Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        field.setSize(width, height);
    }*/

    public void setField(String value) {
        this.field.setText(value);
        field.setCaretPosition(0);
    }
}
