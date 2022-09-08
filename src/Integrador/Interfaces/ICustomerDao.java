package Integrador.Interfaces;

import java.util.ArrayList;

import Integrador.Models.Customer;

public interface ICustomerDao extends IDao<Customer> {
	public String entityName = "customer";
	
	public ArrayList<Customer> getCustomersOrderedByBilling();
}
