package net.jakutenshi.model.sql;

import java.util.HashMap;

public class SQLSchema {
    private final HashMap<String, SQLiteType> schema;

    public SQLSchema(HashMap<String, SQLiteType> schema) {
        this.schema = schema;
    }

    public HashMap<String, SQLiteType> getSchema() {
        return schema;
    }

    public String[] getColumnNames() {
        return schema.keySet().toArray(new String[0]);
    }

    public SQLiteType getType(String name) {
        return schema.get(name);
    }
}
