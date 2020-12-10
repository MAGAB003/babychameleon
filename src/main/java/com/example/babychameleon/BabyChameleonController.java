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
/*
    @GetMapping("/subscriptions/{id}")
    public Subscription getSubscription(Model model, @PathVariable Integer id) {
            Subscription subscription = subscriptionRepository.getSubscription(id);
            model.addAttribute("subscription", subscription);
        return "subscriptionDetails";
    }*/

    @GetMapping("/login")
    public String login() {
        return "login";
    }
@GetMapping("/h2test")
    public String h2test(Model model) {
        List<Subscription> newSubscription = (List<Subscription>)subscriptionRepository.findAll();
        model.addAttribute("subscriptions", newSubscription);
        return "h2test"; }

    @GetMapping("/test")
    public String tst() {
        return "test";
    }
}
