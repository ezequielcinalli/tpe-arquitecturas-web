package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.Models.Customer;
import Integrador.Models.InvoiceProduct;
import Integrador.Interfaces.ICustomerDao;

public class MySqlCustomerDao implements ICustomerDao {

    private Connection connection;

    public MySqlCustomerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Customer> get(int id) {
    	Customer result = null;
        String select = "SELECT * FROM " + entityName + " WHERE id = ? ";
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

    private Customer createEntityFromResultSet(ResultSet rs) throws SQLException {
    	return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	@Override
    public List<Customer> getAll() {
		List<Customer> result = new ArrayList<Customer>();
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
    public void save(Customer t) {
    	String select = "INSERT INTO " + entityName + " (id, name, email) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getEmail());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Customer t) {
    	String select = "UPDATE " + entityName + " SET name=?, email=? WHERE "
    			+ "id=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setString(1, t.getName());
            ps.setString(2, t.getEmail());
            ps.setInt(3, t.getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Customer t) {
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
                CREATE TABLE IF NOT EXISTS customer(
                    id int,
                    name varchar(500),
                    email varchar(150),
                    PRIMARY KEY(id)
                )""";
        try {
            this.connection.prepareStatement(table).execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Customer> getCustomersOrderedByBilling() {
    	ArrayList<Customer> result = new ArrayList<Customer>();
        String select = """
                SELECT c.*
				FROM customer c 
				join invoice i ON c.id = i.customerId 
				JOIN invoice_product ip ON ip.invoiceId = i.id 
				JOIN product p ON ip.productId = p.id 
				group by c.id, c.NAME, c.EMAIL  
				ORDER BY sum(p.value*ip.amount) DESC
                """;
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

}
