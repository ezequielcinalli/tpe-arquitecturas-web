package Integrador.Daos;

import java.util.List;
import java.util.Optional;

import Integrador.Interfaces.IProductDao;
import Integrador.Models.Product;

public class DerbyProductDao implements IProductDao {

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
		// TODO Auto-generated method stub
		
	}

}
