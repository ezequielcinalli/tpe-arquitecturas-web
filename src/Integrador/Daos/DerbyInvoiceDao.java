package Integrador.Daos;

import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IInvoiceDao;
import Integrador.Models.Invoice;

public class DerbyInvoiceDao implements IInvoiceDao {

	@Override
	public Optional<Invoice> get(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Invoice> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Invoice t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Invoice t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Invoice t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
