package net.jakutenshi.ui.components;

import net.jakutenshi.model.entities.enums.EnumString;
import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.ui.components.buttons.ButtonFactory;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

import static net.jakutenshi.utils.Constants.*;

public class EntityComboBoxComponent<T extends SQLEntity> extends FieldComponent {
    private JComboBox<T> comboBox;
    private final AbstractTable<T> model;
    private JButton addButton;

    public EntityComboBoxComponent(AbstractTable<T> model, String description, T initElement) {
        super();
        this.model = model;
        initComponents(description, initElement);
    }

    public EntityComboBoxComponent(AbstractTable<T> model, String description, T initElement, ActionListener addAction) {
        super();
        this.model = model;
        initComponents(description, initElement);
        addButton = ButtonFactory.createButton("Добавить");
        addButton.setEnabled(false);
        addButton.addActionListener( addAction );
        this.add(addButton);
    }

    public Object getValue() {
        return comboBox.getSelectedItem();
    }

    @Override
    public void setEnabled(boolean b) {
            comboBox.setEnabled(b);
            addButton.setEnabled(b);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        comboBox.setSize(width, height);
    }

    private void initComponents(String description, T initElement) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(description));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_BOLD);

        comboBox = new JComboBox<>(new Vector<>(model.getArrayList()));
        comboBox.setSelectedIndex(0);
        comboBox.setFont(FONT);
        comboBox.setEnabled(false);
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
        comboBox.setSelectedItem(initElement);
        this.add(comboBox);

    }
}
