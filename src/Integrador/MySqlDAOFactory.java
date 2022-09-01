package Integrador;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public CustomerDAO getCustomerDAO() {
        return new MySqlCustomerDao();
    }

}
