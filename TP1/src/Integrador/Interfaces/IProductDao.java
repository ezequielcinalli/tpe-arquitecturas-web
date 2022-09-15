package Integrador.Interfaces;

import java.util.List;
import java.util.Optional;

import Integrador.Models.Product;

/**
* Dao de productos
*/
public interface IProductDao extends IDao<Product> {
	
	/**
	* Nombre de la tabla producto en la base de datos
	*/
	public String entityName = "product";
	
	/**
	* Obtiene un producto de la base de datos
	* @param id Id del producto
	* @return Producto en caso de existir, nulo en caso que no exista
	*/
	Optional<Product> get(int id);

	/**
	* Obtiene todos los productos de la base de datos
	* @return Lista de productos
	*/
    List<Product> getAll();

    /**
	* Guarda un producto en la base de datos
	* @param t Producto a guardar
	*/
    void save(Product t);

    /**
	* Actualiza un producto en la base de datos
	* @param t Producto a actualizar
	*/
    void update(Product t);

    /**
	* Borra un producto en la base de datos
	* @param t Producto a borrar
	*/
    void delete(Product t);

    /**
	* Crea la tabla productos en la base de datos
	*/
    void createTable();
}