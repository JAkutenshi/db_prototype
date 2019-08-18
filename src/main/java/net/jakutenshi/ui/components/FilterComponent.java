package net.jakutenshi.ui.components;

import net.jakutenshi.ui.components.buttons.ClearFilterFieldButton;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import static net.jakutenshi.utils.Constants.TEXT_FIELD_HEIGHT;

public class FilterComponent extends JComponent {
    private JTextField filterField;
    private EntitiesListComponent rootPanel;

    public FilterComponent(EntitiesListComponent root) {
        super();
        rootPanel = root;
        setSize(300, TEXT_FIELD_HEIGHT);
        setPreferredSize(getSize());
        initFilterField();
        initClearButton();
    }

    private void initFilterField() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.insets = new Insets(2, 0,0, 2);
        filterField = new JTextField();
        filterField.setFont(Constants.FONT_TERMINUS_ITALIC);
        filterField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                filterList(filterField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                filterList(filterField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                filterList(filterField.getText());
            }
        });
        this.add(filterField, c);
    }

    private void initClearButton() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets.left = 2;
        c.insets.right = 0;
        this.add(new ClearFilterFieldButton(filterField));
    }

    private void filterList(String pattern) {
        rootPanel.filter(pattern);
    }


}
