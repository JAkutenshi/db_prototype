package net.jakutenshi.ui.components.buttons;

import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFilterFieldButton extends JButton {
    private final static int WIDTH  = 45;
    private final static int HEIGHT = Constants.TEXT_FIELD_HEIGHT;
    private JTextField filterField;

    public ClearFilterFieldButton(JTextField filterField) {
        super("X");
        this.filterField = filterField;
        this.setFont(Constants.FONT_TERMINUS_BOLD);
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setPreferredSize(size);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                filterField.setText("");
            }
        });
    }


}
