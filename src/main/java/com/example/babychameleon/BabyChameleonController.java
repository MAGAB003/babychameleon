package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class BabyChameleonController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/aboutservice")
    public String aboutservice() {
        return "aboutservice";
    }

    @GetMapping("/subscriptiondetails")
    public String subscription() {
        return "subscriptiondetails";
    }

    @GetMapping("/subscriptions")
    public String subscriptions(Model model) {
        List<Subscription> newSubscription = (List<Subscription>) subscriptionRepository.findAll();
        model.addAttribute("subscriptions", newSubscription);
        return "subscriptions";
    }

    @GetMapping("/subscription/{id}")
    public String getSubscription(Model model, @PathVariable Long id) {
            Subscription subscription = subscriptionRepository.findById(id).get();
            model.addAttribute("subscription", subscription);
        return "subscriptiondetails";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }


    @GetMapping("/h2test")
    public String h2test(Model model) {
        List<Subscription> subscriptions = (List<Subscription>) subscriptionRepository.findAll();
        model.addAttribute("subscriptions", subscriptions);
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "h2test";
    }

    @GetMapping("/test")
    public String tst() {
        return "test";
    }

    @GetMapping("/h2testCustomer")
    public String h2testCustomer(Model model) {
        List<Customer> customers = (List<Customer>)customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "h2test"; }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/addnewcustomer")
    public String addnewcustomer() {
        return "addNewCustomer";
    }

    @PostMapping("/addnewcustomer")
    public String addnewcustomer(@RequestParam String email, String password, String firstName, String lastName, String streetAddress, String postalCode, String city, String country) {
        User user = userRepository.findByUsername(email);

        if (user == null) {
            Customer customer = new Customer(firstName, lastName, email, streetAddress, postalCode, city, country);
            customerRepository.save(customer);

            user = new User();
            user.setUsername(email);
            user.setPassword(encoder.encode(password));
            user.setCustomerID(customer.getId());
            userRepository.save(user);
        }
        return "index";
    }
}
