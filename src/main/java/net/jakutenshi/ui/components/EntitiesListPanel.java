package net.jakutenshi.ui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EntitiesListPanel extends JPanel {
    private JButton       addButton;
    private JButton       removeButton;
    private JButton       editButton;
    private JList<String> objectsList;
    private ArrayList<String> entitiesModel;

    public EntitiesListPanel(ArrayList<String> entitiesModel) {
        super();
        setSize(300, 45);
        setPreferredSize(getSize());

        this.entitiesModel = entitiesModel;

        addButton = new JButton("+");
        removeButton = new JButton("-");
        editButton = new JButton("E");
        objectsList = new JList<>();
        objectsList.setListData((String[]) entitiesModel.toArray(new String[0]));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(2, 2, 2, 2);
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(new FilterPanel(this), c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        this.add(objectsList, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weighty = 0.0;
        addButton.setPreferredSize(new Dimension(45, 45));
        this.add(addButton, c);
        c.gridx = 1;
        c.gridy = 2;
        removeButton.setPreferredSize(new Dimension(45, 45));
        this.add(removeButton, c);
        c.gridx = 2;
        c.gridy = 2;
        editButton.setPreferredSize(new Dimension(45, 45));
        this.add(editButton, c);
    }

    public String[] getObjects() {
        return entitiesModel.toArray(new String[0]);
    }

    public void setObjectsListValues(String[] s) {
        objectsList.setListData(s);
    }

    public void setEntitiesModel(ArrayList<String> entitiesModel) {
        this.entitiesModel = entitiesModel;
        setObjectsListValues(entitiesModel.toArray(new String[0]));
    }
}
