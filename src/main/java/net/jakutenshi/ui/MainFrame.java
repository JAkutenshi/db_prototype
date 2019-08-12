package net.jakutenshi.ui;

import net.jakutenshi.ui.views.OrganizationsView;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class MainFrame extends JFrame {
    private JTabbedPane tabs;
    private ResourceBundle locale;

    public MainFrame(String title, ResourceBundle locale, JComponent organizationsView) throws HeadlessException {
        super(title);
        this.locale = locale;
        this.setFont(Constants.FONT_TERMINUS);
        UIManager.put( "ComboBox.disabledForeground", Color.BLACK );

        tabs = new JTabbedPane();
        tabs.setFont(this.getFont());
        tabs.addTab(locale.getString("organisation_tab_title"),  organizationsView);
        tabs.addTab(locale.getString("posts_tab_title"),         new JPanel());
        tabs.addTab(locale.getString("employees_tab_title"),     new JPanel());
        tabs.addTab(locale.getString("salary_tab_title"),        new JPanel());
        tabs.addTab(locale.getString("duties_log_tab_title"),    new JPanel());
        this.setContentPane(tabs);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }
}
