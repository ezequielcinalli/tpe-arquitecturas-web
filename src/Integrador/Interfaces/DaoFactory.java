package Integrador.Interfaces;

import java.sql.SQLException;

import Integrador.Factories.DerbyDAOFactory;
import Integrador.Factories.MySqlDAOFactory;

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
