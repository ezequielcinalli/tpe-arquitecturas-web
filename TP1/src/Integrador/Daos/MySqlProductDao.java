package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IProductDao;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public class MySqlProductDao implements IProductDao {

    private Connection connection;

    public MySqlProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Product> get(int id) {
        Product result = null;
        String select = "SELECT * FROM " + entityName + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result = createEntityFromResultSet(rs);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result == null ? Optional.empty() : Optional.of(result);
    }

    @Override
    public List<Product> getAll() {
    	 List<Product> result = new ArrayList<Product>();
         String select = "SELECT * FROM " + entityName;
         try (PreparedStatement ps = connection.prepareStatement(select)) {
             ResultSet rs = ps.executeQuery();
             while (rs.next())
                 result.add(createEntityFromResultSet(rs));
             connection.commit();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return result;
    }

    @Override
    public void save(Product t) {
    	String select = "INSERT INTO " + entityName + " (id,name,value) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
        	ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setFloat(3, t.getValue());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product t) {
    	String select = "UPDATE " + entityName + " SET value=?  WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setFloat(1, t.getValue());
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Product t) {
    	String select = "DELETE FROM " + entityName + " WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, t.getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createTable() {
        String table = """
                CREATE TABLE IF NOT EXISTS product(
                    id int,
                    name varchar(45),
                    value float,
                    PRIMARY KEY(id)
                )""";
        try {
            this.connection.prepareStatement(table).execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Product createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
    }

}
