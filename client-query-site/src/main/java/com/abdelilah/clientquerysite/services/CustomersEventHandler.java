package com.abdelilah.clientquerysite.services;

import com.abdelilah.clientquerysite.entities.Customer;
import com.abdelilah.clientquerysite.repositories.CustomerRepository;
import com.abdelilah.coreapi.events.CustomerCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomersEventHandler {
    private CustomerRepository customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getMail());
        customerRepository.save(customer);
    }
}

