package net.jakutenshi.ui.components;

import net.jakutenshi.model.entities.enums.EnumString;
import net.jakutenshi.model.tables.AbstractTable;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

import static net.jakutenshi.utils.Constants.*;

public class EnumBoxFieldComponent<T extends EnumString> extends JComponent{
    private JComboBox<T> comboBox;
    private final AbstractTable<T> model;
    private JButton addButton;

    public EnumBoxFieldComponent(AbstractTable<T> model, String description) {
        super();
        this.model = model;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(description));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_TERMINUS_BOLD);

        comboBox = new JComboBox<T>(new Vector<>(model.getArrayList()));
        comboBox.setSelectedIndex(0);
        comboBox.setFont(FONT_TERMINUS);
        comboBox.setEnabled(false);
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
        this.add(comboBox);

        addButton = new JButton("Добавить");
        addButton.setEnabled(false);
        addButton.addActionListener( actionEvent -> addNewElement() );
        this.add(addButton);

    }

    public String getValue() {
        return comboBox.getSelectedItem().toString();
    }

    @Override
    public void setEnabled(boolean b) {
            comboBox.setEnabled(b);
            addButton.setEnabled(b);
    }

    private void addNewElement() {
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Введите новый вариант",
                "Добавить новый элемент",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                comboBox.getSelectedItem().toString());
        if (s == null) {
            return;
        }
        if (model.select( object -> object.getName().equals(s) ).size() != 0) {
            JOptionPane.showMessageDialog(this,
                    "Такой элемент уже есть!!",
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        T newE = model.insert((T) new EnumString(-1, s));
        if (newE == null) {
            JOptionPane.showMessageDialog(this,
                    "Не удалось добавить!",
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        comboBox.addItem(newE);
        comboBox.setSelectedItem(newE);
        JOptionPane.showMessageDialog(this, "Добавлено!");
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        comboBox.setSize(width, height);
    }
}
