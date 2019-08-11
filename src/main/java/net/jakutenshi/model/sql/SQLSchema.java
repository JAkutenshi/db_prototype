package net.jakutenshi.model.sql;


import java.util.LinkedHashMap;

public class SQLSchema {
    private final LinkedHashMap<String, SQLiteType> schema;

    public SQLSchema(LinkedHashMap<String, SQLiteType> schema) {
        this.schema = schema;
    }

    public LinkedHashMap<String, SQLiteType> getSchema() {
        return schema;
    }

    public String[] getColumnNames() {
        return schema.keySet().toArray(new String[0]);
    }

    public SQLiteType getType(String name) {
        return schema.get(name);
    }
}
