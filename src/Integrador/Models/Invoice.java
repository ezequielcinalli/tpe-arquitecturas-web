package Integrador.Models;

public class Invoice {
    private int id;
    private int customerId;

    public Invoice(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Invoice [customerId=" + customerId + ", id=" + id + "]";
    }

}
