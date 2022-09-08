package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IInvoiceDao;
import Integrador.Models.Invoice;

public class DerbyInvoiceDao implements IInvoiceDao {

    private Connection connection;

    public DerbyInvoiceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Invoice> get(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Invoice> getAll() {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Invoice t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createTable() {
    	String table = """
                CREATE TABLE invoice(
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

}
