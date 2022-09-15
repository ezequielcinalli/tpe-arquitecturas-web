package Integrador.Connections;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Conexion Derby
*/
public class DerbyConnection {
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String uri = "jdbc:derby:integratorDB;create=true";
    private static Connection connection;

    private DerbyConnection() {
    }

    /**
    * Devuelve una conexion a Derby implementando el patron Singleton
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
            connection = DriverManager.getConnection(uri);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
