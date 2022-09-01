package Integrador.Daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.MyConnection;
import Integrador.Interfaces.IProductDao;
import Integrador.Models.Product;

public class MySqlProductDao implements IProductDao {

    private Connection connection;

    public MySqlProductDao() {
        this.connection = MyConnection.getConnection();
    }

    @Override
    public Optional<Product> get(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Product t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Product t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Product t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createTable() {
        String table = """
                CREATE TABLE IF NOT EXISTS product(
                    id int,
                    name varchar(45),
                    value float,
                    PRIMARY KEY(id)
                )""";
        try {
            this.connection.prepareStatement(table).execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
