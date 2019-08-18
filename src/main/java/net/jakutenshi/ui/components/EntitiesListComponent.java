package net.jakutenshi.ui.components;

import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.ui.components.buttons.ButtonFactory;
import net.jakutenshi.utils.Constants;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

import static net.jakutenshi.utils.Constants.ENTITIES_LIST_WIDTH;
import static net.jakutenshi.utils.Constants.TEXT_FIELD_HEIGHT;

public class EntitiesListComponent<T extends SQLEntity> extends JPanel {
    private JButton       addButton;
    private JButton       removeButton;
    private JButton       editButton;
    private JList<T> objectsList;
    private AbstractTable<T> model;


    public EntitiesListComponent() {
        super();
        this.model = null;
        AddElements();
    }

    public EntitiesListComponent(AbstractTable<T> model) {
        super();
        this.model = model;
        AddElements();
    }

    private void AddElements() {
        this.setMaximumSize(new Dimension(ENTITIES_LIST_WIDTH, Integer.MAX_VALUE));
        this.setPreferredSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
//        this.setBorder(BorderFactory.createTitledBorder("WTF"));

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        FilterComponent filterComponent = new FilterComponent(this);
        filterComponent.setMaximumSize(new Dimension(ENTITIES_LIST_WIDTH, TEXT_FIELD_HEIGHT));
        this.add(filterComponent);

        objectsList = new JList<>();
        objectsList.setFont(Constants.FONT);
        if (model != null) { objectsList.setModel(model.getAbstractList()); }
        objectsList.setMaximumSize(new Dimension(ENTITIES_LIST_WIDTH, Integer.MAX_VALUE));
        JScrollPane scrollPane = new JScrollPane(objectsList);
        scrollPane.setHorizontalScrollBar(new JScrollBar(Adjustable.HORIZONTAL));
        scrollPane.setVerticalScrollBar(new JScrollBar(Adjustable.VERTICAL));
        scrollPane.setMaximumSize(objectsList.getMaximumSize());
        this.add(scrollPane);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        addButton = ButtonFactory.createButton("Добавить");
        buttonsPanel.add(addButton);
        removeButton = ButtonFactory.createButton("Удалить");
        buttonsPanel.add(removeButton);
        editButton = ButtonFactory.createButton("Изменить");
        buttonsPanel.add(editButton);
        buttonsPanel.setMaximumSize(new Dimension(ENTITIES_LIST_WIDTH, TEXT_FIELD_HEIGHT));
        this.add(buttonsPanel);
    }


    public void filter(String pattern) {
        if (model == null) { return; }
        ArrayList<T> filtered = model.filter(pattern);
        objectsList.setListData(new Vector<>(filtered));
        objectsList.setSelectedIndex(-1);
    }

    public void setModel(AbstractTable<T> model) {
        this.model = model;
        objectsList.setModel(model.getAbstractList());
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
