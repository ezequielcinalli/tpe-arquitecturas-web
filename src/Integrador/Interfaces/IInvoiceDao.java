package Integrador.Interfaces;

import java.util.List;
import java.util.Optional;

import Integrador.Models.Invoice;

/**
 * @author Lucas Guerrero
 * @version JavaSE-17
*/
public interface IInvoiceDao extends IDao<Invoice> {
	
	public String entityName = "invoice";
	
	/** 
	 * Devuelve una factura en base a  su id.
	* <p>
	*
	* @param id la id de la factura
	* @return  Optinal con la factura o vacia si la id no coincide con ninguna 	
	*/
	Optional<Invoice> get(int id);
	
	/** 
	 * Devuelve todas las facturas en la base de datos.
	* <p>
	*
	* @param id la id de la factura
	* @return List con todas las facturas en la base de datos
	*/
    List<Invoice> getAll();
    
    /** 
	 * Guarda una factura en la base de datos.
	* <p>
	*
	* @param t la factura a ser guardada
	*/
    void save(Invoice t);
    
    /** 
	 * Actualiza una factura en la base de datos cuya id sea la misma a la
	 * factura dada como parametro.
	* <p>
	*
	* @param t la factura a ser actualizada
	*/
    void update(Invoice t);
    
    /** 
	 * Elimina una factura en la base de datos cuya id sea la misma a la
	 * factura dada como parametro.
	* <p>
	*
	* @param t la factura a ser borrada
	*/
    void delete(Invoice t);
    
    /** 
	 * Crea la tabla de facturas en caso de que esta todavia no exista.
	* <p>
	*/
    void createTable();
}
