package Integrador;

import java.util.ArrayList;

import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.Customer;
import Integrador.Models.Product;
import Integrador.Services.CsvReader;

public class Main {

    public static void main(String[] args) {

        DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JDBC);
        initializeDb(daoFactory);
        seedData(daoFactory);

        ICustomerDao customerDao = daoFactory.getCustomerDao();
        ArrayList<Customer> customersOrderedByBilling = customerDao.getCustomersOrderedByBilling();
        System.out.println(customersOrderedByBilling);

        IInvoiceProductDao invoiceProductDao = daoFactory.getInvoiceProductDao();
        Product mostBilledProduct = invoiceProductDao.getMostBilledProduct();
        System.out.println(mostBilledProduct);
        
        //Product p1 = new Product(1,"compu",1000);
        //daoFactory.getProductDao().save(p1);
        System.out.println(daoFactory.getProductDao().get(1).toString());
        
    }

    public static void initializeDb(DaoFactory daoFactory) {
        try {
            daoFactory.getCustomerDao().createTable();
            daoFactory.getInvoiceDao().createTable();
            daoFactory.getInvoiceProductDao().createTable();
            daoFactory.getProductDao().createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void seedData(DaoFactory daoFactory) {
    	final String basePath = "src\\Integrador\\Data\\";
    	
    	ArrayList<String[]> customers = CsvReader.ReadLinesFromFilePath(basePath + "Customers.csv");
    	// TODO insert in database
    	
    	ArrayList<String[]> invoiceProducts = CsvReader.ReadLinesFromFilePath(basePath + "InvoiceProducts.csv");
    	// TODO insert in database
    	
    	ArrayList<String[]> invoices = CsvReader.ReadLinesFromFilePath(basePath + "Invoices.csv");
    	// TODO insert in database
    	
    	ArrayList<String[]> products = CsvReader.ReadLinesFromFilePath(basePath + "Products.csv");
    	// TODO insert in database
    }

}
