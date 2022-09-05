package Integrador.Factories;

import Integrador.Daos.DerbyCustomerDao;
import Integrador.Daos.DerbyInvoiceDao;
import Integrador.Daos.DerbyInvoiceProductDao;
import Integrador.Daos.DerbyProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;

public class DerbyDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new DerbyCustomerDao();
	}

	@Override
	public IInvoiceDao getInvoiceDao() {
		return new DerbyInvoiceDao();
	}

	@Override
	public IInvoiceProductDao getInvoiceProductDao() {
		return new DerbyInvoiceProductDao();
	}

	@Override
	public IProductDao getProductDao() {
		return new DerbyProductDao();
	}
	
	@Override
	public void initializeDb() {
        try {
        	DerbyCustomerDao customerDao = new DerbyCustomerDao();
            DerbyInvoiceDao invoiceDao = new DerbyInvoiceDao();
            DerbyInvoiceProductDao mySqlInvoiceProductDao = new DerbyInvoiceProductDao();
            DerbyProductDao mySqlProductDao = new DerbyProductDao();
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
