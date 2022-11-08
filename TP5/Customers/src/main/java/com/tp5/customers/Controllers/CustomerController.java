package com.tp5.customers.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {
    
    @GetMapping("/")
    public String getCustomer(){
        return "test works!";
    }
}
