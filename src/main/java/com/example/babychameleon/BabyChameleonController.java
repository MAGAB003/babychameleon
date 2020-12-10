package com.example.babychameleon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class BabyChameleonController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/aboutservice")
    public String aboutservice() {
        return "aboutservice";
    }

    @GetMapping("/subscriptions")
    public String subscriptions() {
        return "subscriptions";
    }

    @GetMapping("/subscriptiondetails")
    public String subscription() {
        return "subscriptiondetails";
    }
/*
    @GetMapping("/subscriptions")
    public String subscriptions(Model model) {
        List<Subscription> subscriptionList = subscriptionRepository.getSubscriptions();
        model.addAttribute("subscriptionList", subscriptionList);
        return "subscriptions";
    }

    @GetMapping("/subscriptions/{id}")
    public Subscription getSubscription(Model model, @PathVariable Integer id) {
            Subscription subscription = subscriptionRepository.getSubscription(id);
            model.addAttribute("subscription", subscription);
        return "subscriptionDetails";
    }*/

    @GetMapping("/login")
    public String login() { return "login"; }
}
