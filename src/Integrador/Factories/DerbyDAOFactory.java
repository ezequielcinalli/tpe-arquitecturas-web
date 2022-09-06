package Integrador.Factories;

import Integrador.Connections.DerbyConnection;
import Integrador.Daos.DerbyCustomerDao;
import Integrador.Daos.DerbyInvoiceDao;
import Integrador.Daos.DerbyInvoiceProductDao;
import Integrador.Daos.DerbyProductDao;
import Integrador.Interfaces.DaoFactory;
import Integrador.Interfaces.ICustomerDao;
import Integrador.Interfaces.IInvoiceDao;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Interfaces.IProductDao;

public class DerbyDAOFactory extends DaoFactory {

    @Override
    public ICustomerDao getCustomerDao() {
        return new DerbyCustomerDao(DerbyConnection.getConnection());
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new DerbyInvoiceDao(DerbyConnection.getConnection());
    }

    @Override
    public IInvoiceProductDao getInvoiceProductDao() {
        return new DerbyInvoiceProductDao(DerbyConnection.getConnection());
    }

    @Override
    public IProductDao getProductDao() {
        return new DerbyProductDao(DerbyConnection.getConnection());
    }

}
