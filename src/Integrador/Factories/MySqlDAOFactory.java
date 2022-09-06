package Integrador.Factories;

import Integrador.Connections.MySqlConnection;
import Integrador.Daos.MySqlCustomerDao;
import Integrador.Daos.MySqlInvoiceDao;
import Integrador.Daos.MySqlInvoiceProductDao;
import Integrador.Daos.MySqlProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;

public class MySqlDAOFactory extends DaoFactory {

    @Override
    public ICustomerDao getCustomerDao() {
        return new MySqlCustomerDao(MySqlConnection.getConnection());
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new MySqlInvoiceDao(MySqlConnection.getConnection());
    }

    @Override
    public IInvoiceProductDao getInvoiceProductDao() {
        return new MySqlInvoiceProductDao(MySqlConnection.getConnection());
    }

    @Override
    public IProductDao getProductDao() {
        return new MySqlProductDao(MySqlConnection.getConnection());
    }

}
