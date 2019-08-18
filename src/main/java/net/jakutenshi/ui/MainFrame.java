package net.jakutenshi.ui;

import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabs;
    private JComponent organizationsView;
    private JComponent postView;
    private JComponent employeesView;
    private JComponent salaryView;
    private JComponent dutiesLogView;

    public MainFrame(JComponent organizationsView, JComponent postView, JComponent employeesView,
                     JComponent salaryView, JComponent dutiesLogView) throws HeadlessException {
        super("БД Охранного Предприятия");
        this.setSize(1280, 720);
        this.setFont(Constants.FONT);
        UIManager.put( "ComboBox.disabledForeground", Color.BLACK );

        tabs = new JTabbedPane();
        tabs.setFont(this.getFont());
        tabs.addTab("Организации", this.organizationsView = organizationsView);
        tabs.addTab("Сотрудники",  this.postView          = postView);
        tabs.addTab("Посты",       this.employeesView     = employeesView);
        tabs.addTab("Зарплата",    this.salaryView        = salaryView);
        tabs.addTab("Дежурства",   this.dutiesLogView     = dutiesLogView);
        this.setContentPane(tabs);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public JComponent getOrganizationsView() {
        return organizationsView;
    }

    public void setOrganizationsView(JComponent organizationsView) {
        this.organizationsView = organizationsView;
    }

    public JComponent getPostView() {
        return postView;
    }

    public void setPostView(JComponent postView) {
        this.postView = postView;
    }

    public JComponent getEmployeesView() {
        return employeesView;
    }

    public void setEmployeesView(JComponent employeesView) {
        this.employeesView = employeesView;
    }

    public JComponent getSalaryView() {
        return salaryView;
    }

    public void setSalaryView(JComponent salaryView) {
        this.salaryView = salaryView;
    }

    public JComponent getDutiesLogView() {
        return dutiesLogView;
    }

    public void setDutiesLogView(JComponent dutiesLogView) {
        this.dutiesLogView = dutiesLogView;
    }
}
