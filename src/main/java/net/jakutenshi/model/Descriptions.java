package net.jakutenshi.model;

import net.jakutenshi.model.sql.SQLiteType;

import java.util.HashMap;

public class Descriptions {
    static {
        HashMap<String, SQLiteType> tmp = new HashMap<>();

        ORGANISATION_TABLE = tmp;
    }

    public static HashMap<String, SQLiteType> ORGANISATION_TABLE;

}
