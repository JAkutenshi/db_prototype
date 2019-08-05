package net.jakutenshi.utils;

import net.jakutenshi.model.sql.SQLSchema;
import net.jakutenshi.model.tables.TableDescription;

public class BuildQueriesUtils {
    public static String buildSQLInsertQuery(TableDescription desc) {
        return "INSERT INTO "+ desc.getTableName() + " "
                + TableDescription.buildAttributesNameTuple(desc.getSchema()) + " VALUES "
                + TableDescription.buildTupleValuesTemplate(desc.getSchema());
    }

    public static String buildSQLDeleteQuery(TableDescription desc, int id) {
        return "DELETE FROM "+ desc.getTableName() + " WHERE id = " + id;
    }

    public static String buildSQLUpdateQuery(TableDescription desc, int id) {
        return "UPDATE " + desc.getTableName() + " SET "
                + TableDescription.buildTupleUpdateTemplate(desc.getSchema()) + " WHERE id = " + id;
    }

    public static String buildSQLGet(TableDescription desc, int id) {
        return "SELECT * FROM " + desc.getTableName() + " WHERE id = " + id;
    }

    public static String buildSQLGetAll(TableDescription desc) {
        return "SELECT * FROM " + desc.getTableName();
    }

    public static String buildSQLGet(String tuple, String fromQuery, int id) {
        return "SELECT "+ tuple + " FROM " + fromQuery + " WHERE id = " + id;
    }

    public static String buildSQLGetAll(String tuple, String fromQuery) {
        return "SELECT " + tuple + " FROM " + fromQuery;
    }

    public static String buildSQLGet(SQLSchema tuple, String fromQuery, int id) {
        return "SELECT "+ TableDescription.buildAttributesNameTuple(tuple) + " FROM " + fromQuery
                + " WHERE id = " + id;
    }

    public static String buildSQLGetAll(SQLSchema tuple, String fromQuery) {
        return "SELECT " + TableDescription.buildAttributesNameTuple(tuple) + " FROM " + fromQuery;
    }
}
