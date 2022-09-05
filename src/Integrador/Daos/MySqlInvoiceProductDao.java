package Integrador.Daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Integrador.MyConnection;
import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public class MySqlInvoiceProductDao implements IInvoiceProductDao {

    private Connection connection;

    public MySqlInvoiceProductDao() {
        this.connection = MyConnection.getConnection();
    }

    @Override
    public Optional<InvoiceProduct> get(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<InvoiceProduct> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(InvoiceProduct t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(InvoiceProduct t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(InvoiceProduct t) {
        // TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

}
