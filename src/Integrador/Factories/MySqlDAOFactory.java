package Integrador.Factories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.Connections.MySqlConnection;
import Integrador.Daos.MySqlCustomerDao;
import Integrador.Daos.MySqlInvoiceDao;
import Integrador.Daos.MySqlInvoiceProductDao;
import Integrador.Daos.MySqlProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;
import Integrador.Models.Customer;
import Integrador.Models.Invoice;

public class MySqlDAOFactory extends DaoFactory {

    @Override
    public ICustomerDao getCustomerDao() {
        return new MySqlCustomerDao(getConnection());
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new MySqlInvoiceDao(getConnection());
    }

    @Override
    public IInvoiceProductDao getInvoiceProductDao() {
        return new MySqlInvoiceProductDao(getConnection());
    }

    @Override
    public IProductDao getProductDao() {
        return new MySqlProductDao(getConnection());
    }

	@Override
	public boolean HasCreatedTables() throws SQLException {
		boolean exists = false;
        String select = """
        		SELECT * 
				FROM information_schema.tables
				WHERE table_schema = 'integratorDB' 
				    AND table_name = 'customer'
				LIMIT 1;
        		""";
        var connection = getConnection();
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            	exists = true;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
	}

	@Override
	public boolean HasCreatedData() {
		List<Customer> customers = getCustomerDao().getAll();
    	return !customers.isEmpty();
	}

	@Override
	public Connection getConnection() {
		return MySqlConnection.getConnection();
	}

}
