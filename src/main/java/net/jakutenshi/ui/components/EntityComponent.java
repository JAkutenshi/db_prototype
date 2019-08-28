package net.jakutenshi.ui.components;

import net.jakutenshi.model.entities.enums.AbsenceReason;
import net.jakutenshi.model.tables.Model;

import javax.swing.*;
import java.awt.*;

public class EntityComponent extends JComponent {
    private JButton editButton   = new JButton("Изменить");
    private JButton applyButton  = new JButton("Принять");
    private JButton cancelButton = new JButton("Отмена");

    public EntityComponent() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        EntityTextFieldComponent f;
        for (int i = 0; i < 3; i++) {
            f = new EntityTextFieldComponent("Информация", "Test", false);
            f.setSize(200, f.getHeight());
            fieldsPanel.add(f);
        }
        fieldsPanel.add(new EntityComboBoxComponent<AbsenceReason>(Model.ABSENCE_REASONS, "Причина отсутствия", Model.ABSENCE_REASONS.getEntity(1)));

        fieldsPanel.add(new DateFieldComponent("Дата", false));

        this.add(fieldsPanel);

        this.add(Box.createVerticalGlue());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        editButton.addActionListener(actionEvent -> {
            editButton.setEnabled(false);
            applyButton.setEnabled(true);
            cancelButton.setEnabled(true);
            for (Component c : fieldsPanel.getComponents()) {
                c.setEnabled(true);
            }
        } );
        buttonsPanel.add(editButton);
        buttonsPanel.add(Box.createHorizontalGlue());
        applyButton.setEnabled(false);
        applyButton.addActionListener(actionEvent -> {
            editButton.setEnabled(true);
            applyButton.setEnabled(false);
            cancelButton.setEnabled(false);
            //ToDo
        });
        buttonsPanel.add(applyButton);
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(actionEvent -> {
            editButton.setEnabled(true);
            applyButton.setEnabled(false);
            cancelButton.setEnabled(false);
            //ToDo
        });
        buttonsPanel.add(cancelButton);
        this.add(buttonsPanel);
    }
}
