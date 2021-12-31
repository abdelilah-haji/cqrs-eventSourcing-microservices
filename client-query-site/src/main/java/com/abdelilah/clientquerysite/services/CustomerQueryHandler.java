package com.abdelilah.clientquerysite.services;

import com.abdelilah.clientquerysite.entities.Customer;
import com.abdelilah.clientquerysite.repositories.CustomerRepository;
import com.abdelilah.coreapi.queries.GetAllCustomersQuery;
import com.abdelilah.coreapi.queries.GetCustomerByIdQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    private CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer customer(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId()).orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }
}
