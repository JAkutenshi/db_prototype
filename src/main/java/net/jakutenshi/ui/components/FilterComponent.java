package net.jakutenshi.ui.components;

import net.jakutenshi.ui.components.buttons.ClearFilterFieldButton;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static net.jakutenshi.utils.Constants.TEXT_FIELD_HEIGHT;

public class FilterComponent extends JComponent {
    private JTextField filterField;
    private EntitiesListComponent rootPanel;

    public FilterComponent(EntitiesListComponent root) {
        super();
        rootPanel = root;
        setSize(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT);
        setMaximumSize(getSize());
        //setPreferredSize(getSize());

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        filterField = new JTextField();
        filterField.setFont(Constants.FONT_ITALIC);
        filterField.setMaximumSize(new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT));
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
        this.add(filterField);
        this.add(new ClearFilterFieldButton(filterField));
    }

    private void filterList(String pattern) {
        rootPanel.filter(pattern);
    }


}
