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
        Child newChild1 = new Child("Knatte", LocalDate.of(2010, 10, 10), false, "Red");
        Child newChild2 = new Child("Fnatte", LocalDate.of(2010, 10, 10), false, "Blue");
        Child newChild3 = new Child("Tjatte", LocalDate.of(2010, 10, 10), false, "Green");
        newCustomer.addChild(newChild1);
        newCustomer.addChild(newChild2);
        newCustomer.addChild(newChild3);

        Optional<Customer> customer = customerRepository.findById(4L);
        Assert.assertFalse("Customer with id=4 should not exist", customer.isPresent());
        Optional<Child> child = childRepository.findById(3L);
        Assert.assertFalse("Child with id=3 should not exist", child.isPresent());

        customerRepository.save(newCustomer);

        customer = customerRepository.findById(4L);
        Assert.assertEquals("Customer with id=4 should exist", newCustomer.getFirstName(), customer.get().getFirstName());
        child = childRepository.findById(3L);
        Assert.assertEquals("Child with id=3 should exist", newChild1.getName(), child.get().getName());

        Assert.assertEquals("Customer should have 3 children", 3, customer.get().getChildren().size());
    }
}
