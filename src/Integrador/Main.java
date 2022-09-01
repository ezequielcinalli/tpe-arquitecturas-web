package Integrador;

import Integrador.Daos.MySqlCustomerDao;
import Integrador.Daos.MySqlInvoiceDao;
import Integrador.Daos.MySqlInvoiceProductDao;
import Integrador.Daos.MySqlProductDao;

public class Main {

    public static void main(String[] args) {
        createTables();
    }

    private static void createTables() {
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

    // private static void dropTables()

}
