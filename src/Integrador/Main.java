package Integrador;

import java.util.ArrayList;

import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.Customer;
import Integrador.Models.Product;

public class Main {

    public static void main(String[] args) {
    	
    	DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JDBC);
    	daoFactory.initializeDb();
    	daoFactory.seedData();
    	
        ICustomerDao customerDao = daoFactory.getCustomerDao();
        ArrayList<Customer> customersOrderedByBilling = customerDao.getCustomersOrderedByBilling();
        System.out.println(customersOrderedByBilling);
        
        IInvoiceProductDao invoiceProductDao = daoFactory.getInvoiceProductDao();
        Product mostBilledProduct = invoiceProductDao.getMostBilledProduct();
        System.out.println(mostBilledProduct);
        
    }

}
