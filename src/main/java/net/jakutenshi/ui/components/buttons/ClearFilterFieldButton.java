package net.jakutenshi.ui.components.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFilterFieldButton extends JButton {
    private final static int WIDTH = 45;
    private final static int HEIGHT = 45;
    private JTextField filterField;

    public ClearFilterFieldButton(JTextField filterField) {
        super("X");
        this.filterField = filterField;
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                filterField.setText("");
            }
        });
    }


}
