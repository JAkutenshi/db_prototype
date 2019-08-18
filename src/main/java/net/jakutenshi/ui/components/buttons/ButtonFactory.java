package net.jakutenshi.ui.components.buttons;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.utils.Constants;

import javax.swing.*;

public class ButtonFactory {
    public static JButton createButton(String title) {
        JButton btn = new JButton(title);
        btn.setFont(Constants.FONT_TERMINUS_BOLD);
        btn.setSize(Constants.BUTTON_SIZE);
        return btn;
    }
}
