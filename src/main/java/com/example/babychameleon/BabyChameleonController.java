package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        return "login";
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

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }


    @PostMapping("/checkout")
    public String addSubscriptions(@RequestParam long id, HttpSession session) {

        Subscription subscription = subscriptionRepository.findById(id).get();
        List<Subscription> subscriptionCart =  (List) session.getAttribute("subscriptionCart");
        if (subscriptionCart == null) {
        //    session.setAttribute("sum", 0);
            subscriptionCart = new ArrayList<>();
            session.setAttribute("subscriptionCart", subscriptionCart);
        }
        //  Om vi vill vi hämta summan?
        //   session.setAttribute("sum", (Integer) session.getAttribute("sum") + subscription.getPrice());
        subscriptionCart.add(subscription);
            return "checkout";
    }

}
