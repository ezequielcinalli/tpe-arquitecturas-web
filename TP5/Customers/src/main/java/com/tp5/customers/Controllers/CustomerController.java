package com.tp5.customers.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.tp5.customers.Services.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tp5.customers.Dtos.CustomerAddDto;
import com.tp5.customers.Dtos.CustomerReportDto;
import com.tp5.customers.Dtos.CustomerUpdateDto;
import com.tp5.customers.Models.Customer;
import com.tp5.customers.Services.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Api(tags = "customers", description = "Servicio de clientes")
@RequestMapping("customers")
public class CustomerController {
	    
	    @Autowired
	    private final CustomerService service;
		@Autowired
		private final AuthService authService;
	    
	    public CustomerController(CustomerService service, AuthService authService){
	       	this.service = service;
			this.authService = authService;
		}
	    
	    @GetMapping("/")
	    public Iterable<Customer> getCustomers(){
	        return service.findAll();
	    }
	    
	    @GetMapping("/{ID}")
	    public Optional<Customer> getCustomerByID(@PathVariable Integer ID){
	        return service.findById(ID);
	    }
	    
	    @PostMapping("/")
	    public Customer save(@RequestBody CustomerAddDto Customer){
	        return service.save(Customer);
	    }
	    
	    @PutMapping("/{ID}")
	    public Customer update(@RequestBody CustomerUpdateDto Customer, @PathVariable Integer ID){
	    	return service.update(Customer, ID);                
	    }
	    
	    @DeleteMapping("/{ID}")
	    public void delete(@PathVariable Integer ID){
	        service.deleteById(ID);
	    }

		@GetMapping("/purchases/amount")
		public Iterable<CustomerReportDto> getPurchasesReport() {
			ArrayList<Customer> customers = (ArrayList<Customer>) service.findAll();
			ArrayList<CustomerReportDto> result = new ArrayList<CustomerReportDto>();
			var internalToken = authService.getInternalJwtToken();

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<>("body", headers);
			headers.add("Authorization", "Bearer " + internalToken);
			String resourceUrl = "http://localhost:9001/sales/amount/";
			
			for (Customer c : customers) {
				ResponseEntity<Float> totalResponse = restTemplate.exchange(resourceUrl + c.getId(), HttpMethod.GET, entity, float.class);
				float total = totalResponse.getBody();
				CustomerReportDto actualCustomer = new CustomerReportDto(c.getName(), total);
				result.add(actualCustomer);
			}

			return result;
		}
}
