package net.jakutenshi.model.tables;

import net.jakutenshi.model.AbstractList;
import net.jakutenshi.model.access.ObjectAccess;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.sql.SQLSchema;
import net.jakutenshi.utils.locales.Utils;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class AbstractTable<T extends SQLEntity> extends AbstractTableModel {
    final private TableDescription description;
    final private String[] columnNames;
    private LinkedHashMap<Long, T> table;
    private ArrayList<Long> keys;

    public AbstractTable(DBTables meta) {
        this.description = new TableDescription(meta);
        table = new LinkedHashMap<>();
        keys  = new ArrayList<>();
        for (SQLEntity t : ObjectAccess.getAll(description)) {
            table.put(t.getID(), (T) t);
            keys.add(t.getID());

        }
        columnNames = meta.getColumnNames();
    }

    public AbstractTable(DBTables meta, String whereQuery) {
        this.description = new TableDescription(meta);
        table = new LinkedHashMap<>();
        keys  = new ArrayList<>();
        for (SQLEntity t : ObjectAccess.getAllWhere(description, whereQuery)) {
            table.put(t.getID(), (T) t);
            keys.add(t.getID());

        }
        columnNames = meta.getColumnNames();
    }

    public TableDescription getDescription() {
        return description;
    }

    public T getEntity(long id) {
        if (table.containsKey(id)) {
            return table.get(id);
        } else {
            return null;
        }
    }

    public ArrayList<T> getArrayList() {
        return Utils.toArrayList(table);
    }

    public ArrayList<String> getStringsArrayList() {
        return Utils.toStringsArrayList(table);
    }

    public AbstractList<T> getAbstractList() {
        return new AbstractList<T>(getArrayList());
    }

    public boolean hasValues() {
        return !table.isEmpty();
    }

    public ArrayList<T> filter(String pattern) {
        String p = pattern.toLowerCase();
        if (pattern.equals("")) {
            return getArrayList();
        } else {
            ArrayList<T> result = new ArrayList<>(); // ToDo: optimize lists performance
            for (T e : getArrayList()) {
                if (e.toString().toLowerCase().contains(p)) {
                    result.add(e);
                }
            }
            return result;
        }
    }

    public ArrayList<T> select(Filter<T> f) {
        ArrayList<T> res = new ArrayList<>();
        T t;
        for (Long k : table.keySet()) {
            t = table.get(k);
            if (f.accept(t)) {
                res.add(t);
            }
        }
        return res;
    }

    public boolean update(T entity) {
        if (!table.containsKey(entity.getID())) { return false; }
        if (!ObjectAccess.update(description, entity)) { return false; }
        table.replace(entity.getID(), entity);
        return true;
    }

    public boolean delete(T entity) {
        if (!table.containsKey(entity.getID())) { return false; }
        if (!ObjectAccess.delete(description, entity)) { return false; }
        table.remove(entity.getID(), entity);
        return true;
    }

    public T insert(T entity) {
        if (table.containsKey(entity.getID())) { return null; }
        long newID = ObjectAccess.insert(description, entity);
        if (newID == -1) { return null; }
        entity.setID(newID);
        table.put(newID, entity);
        keys.add(newID);
        return entity;
    }

    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return description.getColumnsCount();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return table.get(keys.get(row)).getAttribute(column);
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
