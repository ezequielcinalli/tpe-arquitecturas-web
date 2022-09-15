package Integrador.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Integrador.Models.Customer;

public interface ICustomerDao extends IDao<Customer> {
	
	/** 
	 * Nombre de la tabla de BD que representa esta clase
	 * @since septiembre 2022
	 */
	public String entityName = "customer";
	
	/**
	 *  Método que devuelve una lista de clientes ordenadas en forma decreciente
	 *  por el monto total de facturación de cada uno
	 * @return Array List de clientes Customer
	 * @since septiembre 2022
	 */
	public ArrayList<Customer> getCustomersOrderedByBilling();
	
	/**
	 * Obtener los datos de un cliente a partir de su id
	 * 
	 * @author Andrea
	 * @param id de cliente a recuperar
	 * @return devuelve el cliente si lo encuentra en un objeto tipo Customer
	 * @since septiembre 2022
	 */
	Optional<Customer> get(int id);

	/**
	 * Obtener una list con todos los clientes de la tabla customer
	 * 
	 * @author Andrea
	 * @return Lista con datos de clientes
	 * @since septiembre 2022
	 */
    List<Customer> getAll();

    /**
     * Grabar una nuevo cliente en la tabla customer de la BD
     * 
     * @author Andrea
     * @param t es un cliente de la clase Customer
     * @since septiembre 2022
     */
    void save(Customer t);

    /**
     * Actualiza los datos de un cliente
     * 
     * @author Andrea
     * @param t es un cliente de clase Customer
     * @since septiembre 2022
     */
    void update(Customer t);

    /**
     * Eliminar un cliente de la tabla customer
     * 
     * @author Andrea
     * @param t es un cliente de la clase Customer
     * @since septiembre 2022
     */
    void delete(Customer t);

    /**
     * Crea la tabla de clientes (customer)
     * @author Andrea
     * @since septiembre 2022
     */
    void createTable();
}
