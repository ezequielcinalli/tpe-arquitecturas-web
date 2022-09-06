package Integrador;

import java.util.ArrayList;

import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.Customer;
import Integrador.Models.Product;

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
            daoFactory.getInvoiceProductDao().createTable();
            daoFactory.getProductDao().createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void seedData(DaoFactory daoFactory) {
    }

}
