package Integrador.Interfaces;

import Integrador.Models.Product;

public interface IProductDao extends IDao<Product> {
	
	public String entityName = "product";
}