package Integrador.Interfaces;

import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public interface IInvoiceProductDao extends IDao<InvoiceProduct> {
	public Product getMostBilledProduct();
}
