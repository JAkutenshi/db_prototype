package net.jakutenshi.ui.components.buttons;

import net.jakutenshi.utils.Constants;

import javax.swing.*;

public class ButtonFactory {
    public static JButton createButton(String title) {
        JButton btn = new JButton(title);
        btn.setFont(Constants.FONT_BOLD);
        btn.setMaximumSize(Constants.BUTTON_SIZE);
        return btn;
    }
}
