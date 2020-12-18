package com.example.babychameleon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class CustomerAndChildRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ChildRepository childRepository;

    @Test
    void testCustomerExists() {
        Assert.assertEquals("Anton", customerRepository.findById(2L).get().getFirstName());
    }

    @Test
    void testChildExists() {
        Assert.assertEquals("Emil", childRepository.findById(1L).get().getName());
    }

    @Test
    void testCreateCustomerWithChild() {
        Customer newCustomer = new Customer("Kalle", "Anka", "kalle.anka@ankeborg.com", "Ankgatan 1", "Ankeborg", "12345", "USA");
        Child newChild1 = new Child("Knatte", "2010-10-10", false, "Red");
        Child newChild2 = new Child("Fnatte", "2010-10-10", false, "Blue");
        Child newChild3 = new Child("Tjatte", "2010-10-10", false, "Green");
        newCustomer.addChild(newChild1);
        newCustomer.addChild(newChild2);
        newCustomer.addChild(newChild3);

        long countCustomers = customerRepository.count();
        long countChildren = childRepository.count();

        customerRepository.save(newCustomer);

        Optional<Customer> customer = customerRepository.findById(countCustomers + 1);
        Assert.assertEquals("New customer should exist", newCustomer.getFirstName(), customer.get().getFirstName());
        Optional<Child> child = childRepository.findById(countChildren + 1);
        Assert.assertEquals("New child should exist", newChild1.getName(), child.get().getName());

        Assert.assertEquals("Customer should have 3 children", 3, customer.get().getChildren().size());
    }
}
