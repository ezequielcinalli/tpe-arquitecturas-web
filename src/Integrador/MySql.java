package Integrador;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/MySqlDb";
        try {
            Connection connection = DriverManager.getConnection(uri, "root", "password");
            connection.setAutoCommit(false);
            createTables(connection);
            addPerson(connection, 1, "German", 20);
            addPerson(connection, 2, "Sherman", 30);
            select(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String table = "CREATE TABLE PERSON(id int, name varchar(100), age int, PRIMARY KEY(id))";
        connection.prepareStatement(table).execute();
        connection.commit();
    }

    private static void addPerson(Connection connection, int id, String name, int age) throws SQLException {
        String insert = "INSERT INTO PERSON(id, name, age) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.executeUpdate();
        ps.close();
        connection.commit();
    }

    private static void select(Connection connection) throws SQLException {
        String select = "SELECT * FROM PERSON";
        PreparedStatement ps = connection.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
    }

}
