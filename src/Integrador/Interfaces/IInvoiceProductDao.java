package Integrador.Interfaces;

import java.util.Optional;

import Integrador.Models.InvoiceProduct;
import Integrador.Models.Product;

public interface IInvoiceProductDao extends IDao<InvoiceProduct> {
    public String entityName = "invoice_product";

    public Optional<InvoiceProduct> get(int invoiceId, int productId);

    public Product getMostBilledProduct();
}
