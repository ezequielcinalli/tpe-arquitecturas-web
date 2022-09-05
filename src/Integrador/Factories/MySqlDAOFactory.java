package Integrador.Factories;

import Integrador.Daos.MySqlCustomerDao;
import Integrador.Daos.MySqlInvoiceDao;
import Integrador.Daos.MySqlInvoiceProductDao;
import Integrador.Daos.MySqlProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;

public class MySqlDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new MySqlCustomerDao();
	}

	@Override
	public IInvoiceDao getInvoiceDao() {
		return new MySqlInvoiceDao();
	}

	@Override
	public IInvoiceProductDao getInvoiceProductDao() {
		return new MySqlInvoiceProductDao();
	}

	@Override
	public IProductDao getProductDao() {
		return new MySqlProductDao();
	}
	
	@Override
	public void initializeDb() {
        try {
        	MySqlCustomerDao customerDao = new MySqlCustomerDao();
            MySqlInvoiceDao invoiceDao = new MySqlInvoiceDao();
            MySqlInvoiceProductDao mySqlInvoiceProductDao = new MySqlInvoiceProductDao();
            MySqlProductDao mySqlProductDao = new MySqlProductDao();
            customerDao.createTable();
            invoiceDao.createTable();
            mySqlProductDao.createTable();
            mySqlInvoiceProductDao.createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	@Override
	public void seedData() {
		// TODO Auto-generated method stub
		
	}

}
