package net.jakutenshi.model.tables;

import net.jakutenshi.model.sql.SQLSchema;
import net.jakutenshi.model.sql.SQLiteType;
import net.jakutenshi.model.sql.DBTables;

public class TableDescription {
    private final DBTables meta;

    public TableDescription(DBTables meta) {
        this.meta = meta;
    }

    public DBTables getMeta() {
        return meta;
    }

    public String getTableName() {
        return meta.getTableName();
    }

    public SQLSchema getSchema() {
        return meta.getTableSchema();
    }

    public String[] getColumnNames() {
        return getSchema().getColumnNames();
    }

    public SQLiteType getType(String name) {
        return getSchema().getSchema().get(name);
    }

    public int getColumnsCount() {
        int count = getSchema().getSchema().keySet().size();
        return  meta.isIDVisible() ? count : count - 1;
    }

    public static String buildAttributesNameTuple(SQLSchema schema) {
        StringBuilder sb = new StringBuilder("(");
        String[] names = schema.getColumnNames();
        for (int i = 1; i < names.length - 1; i++) {
            sb.append(names[i] + ", ");
        }
        sb.append(names[names.length - 1] + ")");
        return sb.toString();
    }

    public static String buildTupleValuesTemplate(SQLSchema schema) {
        StringBuilder sb = new StringBuilder("(");
        String[] names = schema.getColumnNames();
        for (int i = 1; i < names.length - 1; i++) {
            sb.append("?, ");
        }
        sb.append("?)");
        return sb.toString();
    }

    public static String buildTupleUpdateTemplate(SQLSchema schema) {
        StringBuilder sb = new StringBuilder("");
        String[] names = schema.getColumnNames();
        for (int i = 1; i < names.length - 1; i++) {
            sb.append(names[i] + " = ?, ");
        }
        sb.append(names[names.length - 1] + " = ?");
        return sb.toString();
    }
}
