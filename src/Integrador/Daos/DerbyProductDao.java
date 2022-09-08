package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IProductDao;
import Integrador.Models.Product;

public class DerbyProductDao implements IProductDao {

    private Connection connection;

    public DerbyProductDao(Connection connection) {
        this.connection = connection;
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
    	String select = "INSERT INTO " + entityName + " (id,name,value) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
        	ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setFloat(3, t.getValue());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                CREATE TABLE product(
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
