package net.jakutenshi.model;

import net.jakutenshi.model.sql.SQLEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractList<T extends SQLEntity> extends AbstractListModel<T> {

    private ArrayList<T> list;

    public AbstractList(List<T> list) {
        this.list = (ArrayList<T>) list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElementAt(int i) {
        return list.get(i);
    }
}
