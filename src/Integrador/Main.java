package Integrador;

import java.util.ArrayList;

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

        DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.DERBY_JDBC);

        initializeDb(daoFactory);
        seedData(daoFactory);

        ICustomerDao customerDao = daoFactory.getCustomerDao();
        ArrayList<Customer> customersOrderedByBilling = customerDao.getCustomersOrderedByBilling();
        System.out.println(customersOrderedByBilling);

        IInvoiceProductDao invoiceProductDao = daoFactory.getInvoiceProductDao();
        Product mostBilledProduct = invoiceProductDao.getMostBilledProduct();
        System.out.println(mostBilledProduct);
    }

    public static void initializeDb(DaoFactory daoFactory) {
        try {
            daoFactory.getCustomerDao().createTable();
            daoFactory.getInvoiceDao().createTable();
            daoFactory.getProductDao().createTable();
            daoFactory.getInvoiceProductDao().createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void seedData(DaoFactory daoFactory) {
    	final String basePath = "src\\Integrador\\Data\\";
    	
    	ICustomerDao customerDao = daoFactory.getCustomerDao();
    	ArrayList<String[]> customers = CsvReader.ReadLinesFromFilePath(basePath + "Customers.csv");
    	for (String[] customerParams : customers) {
    		Customer customer = new Customer(Integer. parseInt(customerParams[0]), customerParams[1], customerParams[2]);
    		customerDao.save(customer);
    	}
    	
    	IInvoiceDao invoiceDao = daoFactory.getInvoiceDao();
    	ArrayList<String[]> invoices = CsvReader.ReadLinesFromFilePath(basePath + "Invoices.csv");
		for (String[] invoiceParams : invoices) {
			Invoice invoice = new Invoice(Integer. parseInt(invoiceParams[0]), Integer. parseInt(invoiceParams[1]));
			invoiceDao.save(invoice);
    	}
    	
    	IProductDao productDao = daoFactory.getProductDao();
    	ArrayList<String[]> products = CsvReader.ReadLinesFromFilePath(basePath + "Products.csv");
    	for (String[] productParams : products) {
    		Product product = new Product(Integer. parseInt(productParams[0]), productParams[1], Float.parseFloat(productParams[2]));
    		productDao.save(product);
    	}
    	
    	IInvoiceProductDao invoiceProductDao = daoFactory.getInvoiceProductDao();
    	ArrayList<String[]> invoiceProducts = CsvReader.ReadLinesFromFilePath(basePath + "InvoiceProducts.csv");
    	for (String[] invoiceProductParams : invoiceProducts) {
    		InvoiceProduct invoiceProduct = new InvoiceProduct(
				Integer. parseInt(invoiceProductParams[0]), Integer. parseInt(invoiceProductParams[1]), Integer. parseInt(invoiceProductParams[2]));
    		invoiceProductDao.save(invoiceProduct);
    	}
    }

}
