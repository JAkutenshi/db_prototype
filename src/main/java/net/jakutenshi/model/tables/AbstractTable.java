package net.jakutenshi.model.tables;

import net.jakutenshi.model.access.ObjectAccess;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class AbstractTable<T extends SQLEntity> extends AbstractTableModel {
    final private TableDescription description;
    final private String[] columnNames;
    //private ArrayList<T> table;
    private HashMap<Integer, T> table;
    private ArrayList<Integer> keys;

    public AbstractTable(DBTables meta) {
        this.description = new TableDescription(meta);
        //table = new ArrayList<>();
        table = new HashMap<>();
        keys  = new ArrayList<>();
        for (SQLEntity t : ObjectAccess.getAll(description)) {
            //table.add((T) t);
            table.put(t.getID(), (T) t);
            keys.add(t.getID());

        }
        columnNames = meta.getColumnNames();

    }

    public TableDescription getDescription() {
        return description;
    }

    public T getEntity(int id) {
        if (table.containsKey(id)) {
            return table.get(id);
        } else {
            return null;
        }
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
