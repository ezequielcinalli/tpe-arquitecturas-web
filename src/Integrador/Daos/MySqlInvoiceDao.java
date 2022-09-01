package Integrador.Daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.MyConnection;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Models.Invoice;

public class MySqlInvoiceDao implements IInvoiceDao {

    private Connection connection;

    public MySqlInvoiceDao() {
        this.connection = MyConnection.getConnection();
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
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Invoice t) {
        // TODO Auto-generated method stub

    }

    public void delete(Invoice t) {
        // TODO Auto-generated method stub

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
}