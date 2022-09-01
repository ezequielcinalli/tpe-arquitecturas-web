package Integrador;

public class DerbyDAOFactory extends DAOFactory {

    @Override
    public CustomerDAO getCustomerDAO() {
        return new DerbyCustomerDAO();
    }

}
