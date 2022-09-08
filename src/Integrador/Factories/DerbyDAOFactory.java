package Integrador.Factories;

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
        return new DerbyCustomerDao(DerbyConnection.getConnection());
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new DerbyInvoiceDao(DerbyConnection.getConnection());
    }

    @Override
    public IInvoiceProductDao getInvoiceProductDao() {
        return new DerbyInvoiceProductDao(DerbyConnection.getConnection());
    }

    @Override
    public IProductDao getProductDao() {
        return new DerbyProductDao(DerbyConnection.getConnection());
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
        var connection = MySqlConnection.getConnection();
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

}
