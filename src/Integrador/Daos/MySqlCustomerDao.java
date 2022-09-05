package Integrador.Daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.Models.Customer;
import Integrador.MyConnection;
import Integrador.Interfaces.ICustomerDao;

public class MySqlCustomerDao implements ICustomerDao {

    private Connection connection;

    public MySqlCustomerDao() {
        this.connection = MyConnection.getConnection();
    }

    @Override
    public Optional<Customer> get(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Customer t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Customer t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Customer t) {
        // TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

}
