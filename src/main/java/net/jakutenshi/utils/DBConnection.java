package net.jakutenshi.utils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static {
        /*JFileChooser fc = new JFileChooser(".", FileSystemView.getFileSystemView());
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            DB_URI = "jdbc:sqlite:" + fc.getSelectedFile().getPath();
        } else {
            System.exit(1);
        }*/
        DB_URI = "jdbc:sqlite:/home/jakutenshi/projects/java/db_prototype/src/main/resources/security_corp.sqlite3";
    }
    //ToDo: make uri configurable and relative
    //private static String DB_URI = "jdbc:sqlite:/home/jakutenshi/projects/java/db_prototype/src/main/resources/security_corp.sqlite3";
    private static String DB_URI;
    private static DBConnection instance;
    private static Connection connection;

    private static void tryConnect() {
        try {
            System.out.println(DB_URI);
            connection = DriverManager.getConnection(DB_URI);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection = null;
        } finally {
            System.out.println("Connection to SQLite has been established.");

        }
    }

    private DBConnection() {
        tryConnect();
    }

    public static synchronized Connection getConnection() {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.connection == null) {
            tryConnect();
        }
        return instance.connection;
    }
}
