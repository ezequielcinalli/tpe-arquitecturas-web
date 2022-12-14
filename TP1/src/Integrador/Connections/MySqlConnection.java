package Integrador.Connections;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Conexion MySql
*/
public class MySqlConnection {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String uri = "jdbc:mysql://localhost:3306/integratorDB";
    private static Connection connection;

    private MySqlConnection() {
    }

    /**
     * Devuelve una conexion a MySql implementando el patron Singleton
     */
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            connection = DriverManager.getConnection(uri, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
