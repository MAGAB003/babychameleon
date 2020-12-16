package com.example.babychameleon;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public List<Customer> findByEmail(String email);

}
