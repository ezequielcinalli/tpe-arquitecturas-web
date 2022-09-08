package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IInvoiceDao;
import Integrador.Models.Invoice;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public class MySqlInvoiceDao implements IInvoiceDao {

    private Connection connection;

    public MySqlInvoiceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Invoice> get(int id) {
    	Invoice result = null;
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
    public List<Invoice> getAll() {
    	List<Invoice> result = new ArrayList<Invoice>();
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
    public void save(Invoice t) {
    	String select = "INSERT INTO " + entityName + " (id,customerId) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
        	ps.setInt(1, t.getId());
            ps.setInt(2, t.getCustomerId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Invoice t) {
    	String select = "UPDATE " + entityName + " SET customerId=?  WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setFloat(1, t.getCustomerId());
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Invoice t) {
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
                CREATE TABLE IF NOT EXISTS invoice(
                    id int,
                    customerId int,
                    PRIMARY KEY(id),
                    FOREIGN KEY (customerId) REFERENCES customer(id)
                )""";
        try {
            this.connection.prepareStatement(table).execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Invoice createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new Invoice(rs.getInt(1), rs.getInt(2));
    }
}