package net.jakutenshi.ui.components;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

import static net.jakutenshi.utils.Constants.ENTITIES_LIST_WIDTH;

public class EntitiesListComponent<T extends SQLEntity> extends JComponent implements PropertyChangeListener {
    private JButton       addButton;
    private JButton       removeButton;
    private JButton       editButton;
    private JList<T> objectsList;
    private AbstractTable<T> model;
    private PropertyChangeSupport support;
    private T selectedEntity;

    public EntitiesListComponent(AbstractTable<T> model) {
        super();
        setSize(ENTITIES_LIST_WIDTH, Integer.MAX_VALUE);
        setPreferredSize(getSize());
        setMaximumSize(getSize());

        this.model = model;
        support = new PropertyChangeSupport(this);

        AddElements();
    }

    private void AddElements() {
        addButton = new JButton("Добавить");
        addButton.setFont(Constants.FONT_TERMINUS_BOLD);
        removeButton = new JButton("Удалить");
        removeButton.setFont(Constants.FONT_TERMINUS_BOLD);
        editButton = new JButton("Изменить");
        editButton.setFont(Constants.FONT_TERMINUS_BOLD);
        objectsList = new JList<>(model.getAbstractList());
        objectsList.setFont(Constants.FONT_TERMINUS);
        if (model.hasValues()) {
            objectsList.setSelectedIndex(0);
            selectedEntity = objectsList.getSelectedValue();
        }

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(new FilterComponent(this), c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scrollPane.add(objectsList);
        this.add(scrollPane, c);

        Dimension buttonSize = new Dimension(Constants.TEXT_FIELD_HEIGHT, Constants.TEXT_FIELD_HEIGHT);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weighty = 0.0;
        addButton.setPreferredSize(buttonSize);
        this.add(addButton, c);
        c.gridx = 1;
        c.gridy = 2;
        removeButton.setPreferredSize(buttonSize);
        this.add(removeButton, c);
        c.gridx = 2;
        c.gridy = 2;
        editButton.setPreferredSize(buttonSize);
        this.add(editButton, c);
    }


    public void filter(String pattern) {
        ArrayList filtered = model.filter(pattern);
        objectsList.setListData(new Vector<>(filtered));
        objectsList.setSelectedIndex(-1);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setModel(AbstractTable<T> model) {
        this.model = model;
        objectsList.setModel(model.getAbstractList());
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        //ObjectAccess.getAllWhere(new TableDescription())
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JList<T> getObjectsList() {
        return objectsList;
    }

    public T getSelectedEntity() {
        return objectsList.getSelectedValue();
    }
}
