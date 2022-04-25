package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static Util instance;
    private Connection connection;
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root2503";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    protected Util() throws SQLException {
        try {
            Class.forName(DB_Driver);
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static Util getInstance() throws SQLException {
        if (instance == null) {
            instance = new Util();
        } else if (instance.getConnection().isClosed()) {
            instance = new Util();
        }

        return instance;
    }
}



