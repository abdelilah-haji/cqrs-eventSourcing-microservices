package com.abdelilah.clientquerysite.repositories;

import com.abdelilah.clientquerysite.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
