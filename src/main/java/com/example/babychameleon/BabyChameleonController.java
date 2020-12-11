package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import java.util.List;

@Controller
public class BabyChameleonController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;

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
        List<Subscription> newSubscription = (List<Subscription>)subscriptionRepository.findAll();
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
        return "login";
    }
@GetMapping("/h2test")
    public String h2test(Model model) {
        List<Subscription> subscriptions = (List<Subscription>)subscriptionRepository.findAll();
        model.addAttribute("subscriptions", subscriptions);
        return "h2test"; }

    @GetMapping("/test")
    public String tst() {
        return "test";
    }

    @GetMapping("/h2testCustomer")
    public String h2testCustomer(Model model) {
        List<Customer> customers = (List<Customer>)customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "h2test"; }
}
