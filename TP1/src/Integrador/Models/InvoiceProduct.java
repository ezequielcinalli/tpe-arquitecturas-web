package Integrador.Models;

public class InvoiceProduct {
    private int invoiceId;
    private int productId;
    private int amount;

    public InvoiceProduct(int invoiceId, int productId, int amount) {
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.amount = amount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InvoiceProduct [amount=" + amount + ", invoiceId=" + invoiceId + ", productId=" + productId + "]";
    }
}
