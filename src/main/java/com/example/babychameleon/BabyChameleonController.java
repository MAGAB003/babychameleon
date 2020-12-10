package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/subscriptions")
    public String subscriptions() {
        return "subscriptions";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/h2test")
    public String h2test(Model model) {
        List<Subscription> newSubscription = (List<Subscription>)subscriptionRepository.findAll();
        model.addAttribute("subscriptions", newSubscription);
        return "h2test"; }
}
