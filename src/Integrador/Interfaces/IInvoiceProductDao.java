package Integrador.Interfaces;

import java.util.List;
import java.util.Optional;

import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

/**
 * Representa la entidad factura-producto.
 * 
 * @author ezequielcinalli
 * @version 1.0
 */
public interface IInvoiceProductDao extends IDao<InvoiceProduct> {
    public String entityName = "invoice_product";

    /**
     * Retorna el producto con el id de factura y producto indicados
     * 
     * @param invoiceId id de la factura
     * @param productId id del producto
     * @return InvoiceProduct
     * 
     */
    public Optional<InvoiceProduct> get(int invoiceId, int productId);

    /**
     * Retorna el producto con mayor recaudacion
     * 
     * @return el producto
     * @see IProductDao
     */
    public Product getMostBilledProduct();

    /**
     * Retorna el producto con el id indicado
     * 
     * @deprecated usar el metodo get con signatura de 2 parametros
     * @param id el id de la factura
     * @return La factura-producto con el id indicado
     */
    Optional<InvoiceProduct> get(int id);

    /**
     * Retorna un listado de factura-producto
     * 
     * @return el listado de factura-producto
     */
    List<InvoiceProduct> getAll();

    /**
     * Crea en la base de datos la factura-producto
     * 
     * @param invoiceProduct la factura-producto a crear
     */
    void save(InvoiceProduct invoiceProduct);

    /**
     * Actualiza en la base de datos la factura-producto
     * 
     * @param invoiceProduct
     */
    void update(InvoiceProduct invoiceProduct);

    /**
     * Elimina en la base de datos la factura-producto
     * 
     * @param invoiceProduct la factura-producto a eliminar
     */
    void delete(InvoiceProduct invoiceProduct);

    /**
     * Crea la tabla invoice_product en la base de datos
     */
    void createTable();
}
