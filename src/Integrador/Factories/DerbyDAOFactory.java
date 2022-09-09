package Integrador.Factories;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Integrador.Connections.DerbyConnection;
import Integrador.Connections.MySqlConnection;
import Integrador.Daos.DerbyCustomerDao;
import Integrador.Daos.DerbyInvoiceDao;
import Integrador.Daos.DerbyInvoiceProductDao;
import Integrador.Daos.DerbyProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;
import Integrador.Models.Customer;

public class DerbyDAOFactory extends DaoFactory {

    @Override
    public ICustomerDao getCustomerDao() {
        return new DerbyCustomerDao(getConnection());
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new DerbyInvoiceDao(getConnection());
    }

    @Override
    public IInvoiceProductDao getInvoiceProductDao() {
        return new DerbyInvoiceProductDao(getConnection());
    }

    @Override
    public IProductDao getProductDao() {
        return new DerbyProductDao(getConnection());
    }

	@Override
	public boolean HasCreatedTables() throws SQLException {
		boolean exists = false;
		var connection = getConnection();
		DatabaseMetaData dbm = connection.getMetaData();
        ResultSet rs = dbm.getTables(null, "APP", "CUSTOMER", null);
        if (rs.next())
            exists = true;
        return exists;
	}

	@Override
	public boolean HasCreatedData() {
		List<Customer> customers = getCustomerDao().getAll();
    	return !customers.isEmpty();
	}

	@Override
	public Connection getConnection() {
		return DerbyConnection.getConnection();
	}

}
