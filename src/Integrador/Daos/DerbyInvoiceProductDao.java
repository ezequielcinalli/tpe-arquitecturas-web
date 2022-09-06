package Integrador.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.MyConnection;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public class DerbyInvoiceProductDao implements IInvoiceProductDao {

    private Connection connection;

    public DerbyInvoiceProductDao() {
        this.connection = MyConnection.getConnection();
    }

    @Override
    public Optional<InvoiceProduct> get(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<InvoiceProduct> get(int invoiceId, int productId) {
        InvoiceProduct result = null;
        String select = "SELECT * FROM " + entityName + " WHERE invoiceId = ? AND productId = ?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, invoiceId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result = createEntityFromResultSet(rs);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result == null ? Optional.empty() : Optional.of(result);
    }

    @Override
    public List<InvoiceProduct> getAll() {
        List<InvoiceProduct> result = new ArrayList<InvoiceProduct>();
        String select = "SELECT * FROM " + entityName;
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                result.add(createEntityFromResultSet(rs));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(InvoiceProduct t) {
        String select = "INSERT INTO " + entityName + " (invoiceId,productId,amount) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, t.getInvoiceId());
            ps.setInt(2, t.getProductId());
            ps.setInt(3, t.getAmount());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(InvoiceProduct t) {
        String select = "UPDATE " + entityName + " SET amount=?  WHERE invoiceId=? AND productId=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, t.getAmount());
            ps.setInt(2, t.getInvoiceId());
            ps.setInt(3, t.getProductId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(InvoiceProduct t) {
        String select = "DELETE FROM " + entityName + " WHERE invoiceId=? AND productId=?";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setInt(1, t.getInvoiceId());
            ps.setInt(2, t.getProductId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        String table = """
                    CREATE TABLE IF NOT EXISTS invoice_product(
                    invoiceId int,
                    productId int,
                    amount int,
                    PRIMARY KEY(invoiceId,productId),
                    FOREIGN KEY (invoiceId) REFERENCES invoice(id),
                    FOREIGN KEY (productId) REFERENCES product(id)
                )""";
        try {
            this.connection.prepareStatement(table).execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getMostBilledProduct() {
        Product result = null;
        String select = """
                SELECT p.*
                FROM product p
                JOIN invoice_product ip
                ON p.id = ip.productId
                WHERE p.value*ip.amount  = (SELECT MAX(p2.value*ip2.amount) FROM product p2
                                            JOIN invoice_product ip2
                                            ON p2.id = ip2.productId)""";
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private InvoiceProduct createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new InvoiceProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3));
    }

}
