package net.jakutenshi.ui.components;

import jdk.internal.org.jline.terminal.Size;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static net.jakutenshi.utils.Constants.*;

public class TextFieldPanel extends JPanel {
    private JTextField field;
    private final boolean readOnly;

    public TextFieldPanel(String description, boolean readOnly) {
        super();
        this.readOnly = readOnly;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(description));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_TERMINUS_BOLD);

        field = new JTextField("Test");
        field.setFont(FONT_TERMINUS);
        field.setEditable(false);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
        this.add(field);
    }

    public String getValue(){
        return field.getText();
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
}
