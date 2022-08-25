package Exercise2;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseV2Mysql {

    public static void main(String[] args) {
	String driver = "com.mysql.cj.jdbc.Driver";

	try {
	    Class.forName(driver).getDeclaredConstructor().newInstance();
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
		| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
	    e.printStackTrace();
	    System.exit(1);
	}

	String uri = "jdbc:mysql://localhost:3306/exampleDB";

	try {
	    Connection conn = DriverManager.getConnection(uri, "root", "");
	    conn.setAutoCommit(false);
//	    createTables(conn);
//	    addPerson(conn, 1, "Juan", 20);
//	    addPerson(conn, 2, "Paula", 30);
	    String select = "SELECT * FROM persona";
	    PreparedStatement ps = conn.prepareStatement(select);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
	    }
	    conn.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

    private static void addPerson(Connection conn, int id, String name, int years) throws SQLException {
	String insert = "INSERT INTO persona (id,nombre,edad) VALUES(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(insert);
	ps.setInt(1, id);
	ps.setString(2, name);
	ps.setInt(3, years);
	ps.execute();
	ps.close();
	conn.commit();
    }

    private static void createTables(Connection conn) throws SQLException {
	String table = "CREATE TABLE persona(id INT, nombre VARCHAR(500), edad INT, PRIMARY KEY(id))";
	conn.prepareStatement(table).execute();
	conn.commit();
    }
}
