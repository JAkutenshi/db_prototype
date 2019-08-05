package net.jakutenshi.model.sql;

import net.jakutenshi.model.entities.Absence;
import net.jakutenshi.model.entities.Organization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public enum DBTables {
    ORGANIZATION,
    ABSENCE;

    public SQLEntity getEntity(ResultSet rs) throws SQLException {
        switch (this) {
            case ORGANIZATION:
                return new Organization(rs);
            case ABSENCE:
                return new Absence(rs);
            default:
                return null;
        }
    }

    public String getTableName() {
        switch (this) {
            case ORGANIZATION:
                return "Organization";
            case ABSENCE:
                return "Absence";
            default:
                return null;
        }
    }

    public SQLSchema getTableSchema() {
        HashMap<String, SQLiteType> schema = new HashMap<>();
        switch (this) {
            case ORGANIZATION:
                schema.put("id", SQLiteType.INTEGER);
                schema.put("name", SQLiteType.TEXT);
                schema.put("legal_address", SQLiteType.TEXT);
                schema.put("phone_num", SQLiteType.TEXT);
                return new SQLSchema(schema);
            case ABSENCE:
                schema.put("id", SQLiteType.INTEGER);
                schema.put("duty_id", SQLiteType.INTEGER);
                schema.put("reason_id", SQLiteType.INTEGER);
                return new SQLSchema(schema);
            default:
                return null;
        }
    }

    public String[] getColumnNames() {
        switch (this) {
            case ORGANIZATION:
                return new String[] {"Название", "Юр. Адрес", "Телефон"};
            case ABSENCE:
                return new String[] {"Номер дежурства", "Причина"};
            default:
                return null;
        }
    }
}
