package Integrador.Interfaces;

import Integrador.Models.Invoice;

public interface IInvoiceDao extends IDao<Invoice> {
	
	public String entityName = "invoice";
}
