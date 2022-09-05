package Integrador.Daos;

import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IInvoiceProductDao;
import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public class DerbyInvoiceProductDao implements IInvoiceProductDao {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getMostBilledProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
