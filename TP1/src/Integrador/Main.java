package Integrador;

import java.util.ArrayList;
import java.util.List;

import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;
import Integrador.Models.Customer;
import Integrador.Models.Invoice;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;
import Integrador.Services.CsvReader;

public class Main {

    public static void main(String[] args) {
    	
    	// Change between factory implementations
    	
    	// DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.DERBY_JDBC);
        DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JDBC);

        DaoFactory.initializeDb(daoFactory);
        DaoFactory.seedData(daoFactory);
        
        ICustomerDao customerDao = daoFactory.getCustomerDao();
        ArrayList<Customer> customersOrderedByBilling = customerDao.getCustomersOrderedByBilling();
        System.out.println("--------------Clientes ordenados por facturación--------------") ;
        for (Customer c : customersOrderedByBilling) {
        	System.out.println(c);
        }

        System.out.println("------------------------------------------------------") ;
        IInvoiceProductDao invoiceProductDao = daoFactory.getInvoiceProductDao();
        Product mostBilledProduct = invoiceProductDao.getMostBilledProduct();
        System.out.println("Producto que más recaudó: " + mostBilledProduct);
    }

}
