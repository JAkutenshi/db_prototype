package net.jakutenshi.ui.components;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.ui.components.buttons.ButtonFactory;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.*;

import static net.jakutenshi.utils.Constants.*;

public class EntitiesListComponent<T extends SQLEntity> extends JPanel {
    private JButton       addButton;
    private JButton       removeButton;
    private JButton       editButton;
    private JList<T> objectsList;
    private AbstractTable<T> model;


    public EntitiesListComponent(String title) {
        super();
        this.model = null;
        initComponent(title);
    }

    public EntitiesListComponent(String title, AbstractTable<T> model) {
        super();
        this.model = model;
        initComponent(title);
    }

    private void initComponent(String title) {
        this.setMaximumSize(new Dimension(ENTITIES_LIST_WIDTH, Integer.MAX_VALUE));
        this.setPreferredSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
        this.setBorder(BorderFactory.createTitledBorder(title));
        ((TitledBorder) this.getBorder()).setTitleFont(FONT_BOLD);

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

    public void clear() {
        this.setModel(null);
    }
}
