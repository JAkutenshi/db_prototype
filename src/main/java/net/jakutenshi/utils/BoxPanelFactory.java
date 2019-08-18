package net.jakutenshi.utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BoxPanelFactory {
    public static JPanel create(int axisType) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, axisType));
        return panel;
    }

    public static JPanel create(int axisType, String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, axisType));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        ((TitledBorder) panel.getBorder()).setTitleFont(Constants.FONT_BOLD);
        return panel;
    }
}
