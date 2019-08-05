package net.jakutenshi.model;

import net.jakutenshi.utils.DBConnection;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class MainTableModel extends AbstractTableModel {
    private int columnsCount;
    private LinkedList<Object[]> table;

    public MainTableModel(int columns, int rows) {
        Connection dbConection = DBConnection.getConnection();
        // ToDo: how to handle exception?
        try {
            dbConection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("DB connection closed clear");
        }

        columnsCount = columns;
        table = new LinkedList<Object[]>();
        for (int row = 0; row < rows; row++) {
            table.add(new Object[columnsCount]);
            for (int i = 0; i < columnsCount; i++) {
                table.getLast()[i] = i * row;
            }
        }

    }

    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return columnsCount;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return table.get(row)[column];
    }

    @Override
    public String getColumnName(int column) {
        String result;
        switch (column) {
            case 0:
                result = "Фамилия";
                break;
            case 1:
                result = "Имя";
                break;
            case 2:
                result = "Отчество";
                break;
            case 3:
                result = "Телефон";
                break;
            case 4:
                result = "Дата переподготовки";
                break;
            default:
                result = "ОШИБКА";
        }
        return result;
    }
}
