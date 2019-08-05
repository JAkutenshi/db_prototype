package net.jakutenshi.ui.views;

import net.jakutenshi.model.MainTableModel;

import javax.swing.*;
import java.awt.*;

public class MainTableView extends JPanel {
    private JTable mainTable = new JTable(new MainTableModel(5, 1000));
    //private JPanel mainPanel;

    public MainTableView() throws HeadlessException {
        super(new BorderLayout());

        init();
    }

    private void init() {
        /*for (var v : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
            System.out.println(v);
        }*/
        mainTable.setFont(new Font("Terminus (TTF)", Font.PLAIN, 18));
        //mainTable.setFont(new Font("Times New Roman", 0, 18));
        mainTable.getTableHeader().setFont(new Font("Terminus (TTF)", Font.BOLD, 18));
        mainTable.setRowHeight(mainTable.getFont().getSize() * 2);
        this.add(new JScrollPane(mainTable));
    }
}
