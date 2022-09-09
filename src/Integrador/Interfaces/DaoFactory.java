package Integrador.Interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Integrador.Factories.DerbyDAOFactory;
import Integrador.Factories.MySqlDAOFactory;
import Integrador.Models.Customer;
import Integrador.Models.Invoice;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;
import Integrador.Services.CsvReader;

/**
* Fabrica general de Daos
*/
public abstract class DaoFactory {
	
	/**
	* Parametro para generar Daos utilizando MYSQL
	*/
    public static final int MYSQL_JDBC = 1;
    
    /**
    * Parametro para generar Daos utilizando DERBY
    */
    public static final int DERBY_JDBC = 2;
    
    /**
	* Devuelve una instancia de fabrica de Daos con el tipo de base de datos especificado
	* @param whichFactory Id de la base de datos a utilizar
	* @return Instancia de clase que extienda DaoFactory
	*/
    public static DaoFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC:
                return new MySqlDAOFactory();
            case DERBY_JDBC:
                return new DerbyDAOFactory();
            default:
                return null;
        }
    }
    
    /**
	* Inicializa la base de datos con las tablas correspondientes
	* @param daoFactory Instancia de fabrica especificada
	*/
    public static void initializeDb(DaoFactory daoFactory) {
        try {
        	if (daoFactory.HasCreatedTables())
        		return;
        		
        	daoFactory.getCustomerDao().createTable();
            daoFactory.getInvoiceDao().createTable();
            daoFactory.getProductDao().createTable();
            daoFactory.getInvoiceProductDao().createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
	* Crea los registros en las tablas correspondientes
	* @param daoFactory Instancia de fabrica especificada
	*/
    public static void seedData(DaoFactory daoFactory) {
    	if (daoFactory.HasCreatedData())
    		return;
    	
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

    /**
	* Devuelve una implementación de ICustomerDao con la base de datos especificada
	* @return Instancia de clase que implemente ICustomerDao
	*/
    public abstract ICustomerDao getCustomerDao();

    /**
	* Devuelve una implementación de IInvoiceDao con la base de datos especificada
	* @return Instancia de clase que implemente IInvoiceDao
	*/
    public abstract IInvoiceDao getInvoiceDao();

    /**
	* Devuelve una implementación de IInvoiceProductDao con la base de datos especificada
	* @return Instancia de clase que implemente IInvoiceProductDao
	*/
    public abstract IInvoiceProductDao getInvoiceProductDao();

    /**
	* Devuelve una implementación de IProductDao con la base de datos especificada
	* @return Instancia de clase que implemente IProductDao
	*/
    public abstract IProductDao getProductDao();
    
    /**
	* Devuelve una conexion a la base de datos especificada
	* @return Conexion a la base de datos especificada
	*/
    public abstract Connection getConnection();
    
    /**
	* Verifica si ya se crearon las tablas necesarias
	* @return Verdadero si se crearon, falso si no
	*/
    public abstract boolean HasCreatedTables() throws SQLException;
    
    /**
	* Verifica si ya se insertaron los datos necesarios
	* @return Verdadero si se insertaron, falso si no
	*/
    public abstract boolean HasCreatedData();

}
