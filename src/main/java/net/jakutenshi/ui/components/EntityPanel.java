package net.jakutenshi.ui.components;

import net.jakutenshi.model.entities.Absence;
import net.jakutenshi.model.entities.enums.AbsenceReason;
import net.jakutenshi.model.tables.Model;

import javax.swing.*;
import java.awt.*;

public class EntityPanel extends JPanel {
    private JButton editButton   = new JButton("Изменить");
    private JButton applyButton  = new JButton("Принять");
    private JButton cancelButton = new JButton("Отмена");

    public EntityPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        TextFieldPanel f;
        for (int i = 0; i < 10; i++) {
            f = new TextFieldPanel("Информация", false);
            f.setSize(200, f.getHeight());
            fieldsPanel.add(f);
        }
        fieldsPanel.add(new ComboBoxFieldPanel<AbsenceReason>(Model.ABSENCE_REASONS, "Причина отсутствия"));
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
        });
        buttonsPanel.add(applyButton);
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(actionEvent -> {
            editButton.setEnabled(true);
            applyButton.setEnabled(false);
            cancelButton.setEnabled(false);
        });
        buttonsPanel.add(cancelButton);
        this.add(buttonsPanel);
    }
}
