package Integrador.Interfaces;

import java.sql.SQLException;

import Integrador.Factories.DerbyDAOFactory;
import Integrador.Factories.MySqlDAOFactory;

public abstract class DaoFactory {

    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;

    public abstract ICustomerDao getCustomerDao();

    public abstract IInvoiceDao getInvoiceDao();

    public abstract IInvoiceProductDao getInvoiceProductDao();

    public abstract IProductDao getProductDao();

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
    
    public abstract boolean HasCreatedTables() throws SQLException;
    
    public abstract boolean HasCreatedData();

}
