package net.jakutenshi.ui.components;

import net.jakutenshi.model.access.ObjectAccess;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.model.tables.TableDescription;
import net.jakutenshi.utils.locales.Utils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

public class EntitiesListPanel<T extends SQLEntity> extends JPanel implements PropertyChangeListener {
    private JButton       addButton;
    private JButton       removeButton;
    private JButton       editButton;
    private JList<T> objectsList;
    private AbstractTable<T> model;
    private PropertyChangeSupport support;
    private T selectedEntity;

    public EntitiesListPanel(AbstractTable<T> model) {
        super();
        setSize(300, 45);
        setPreferredSize(getSize());

        this.model = model;
        support = new PropertyChangeSupport(this);

        AddElements();
        setEventListeners();
    }

    private void AddElements() {
        addButton = new JButton("+");
        removeButton = new JButton("-");
        editButton = new JButton("E");
        objectsList = new JList<>(model.getAbstractList());
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

    private void setEventListeners() {
        objectsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting()) {
                    selectionHandler(listSelectionEvent);
                }
            }
        });
    }

    public void filter(String pattern) {
        objectsList.setListData(new Vector<>(model.filter(pattern)));
    }

    private void selectionHandler(ListSelectionEvent listSelectionEvent) {
        T newValue = objectsList.getSelectedValue();
        selectedEntity = newValue;
        support.firePropertyChange("selectedEntity", selectedEntity, newValue);
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
}
