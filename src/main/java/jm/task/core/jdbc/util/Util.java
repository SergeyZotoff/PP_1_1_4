package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root2503";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    public static Connection getConnection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Connection connection = null;
        try {
            Class.forName(DB_Driver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
