package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class BabyChameleonController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ChildRepository childRepository;
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
        model.addAttribute("subscriptions", (List<Subscription>) subscriptionRepository.findAll());
        model.addAttribute("customers", (List<Customer>) customerRepository.findAll());
        model.addAttribute("children", (List<Child>) childRepository.findAll());
        return "h2test";
    }

    @GetMapping("/test")
    public String tst() {
        return "test";
    }

    @GetMapping("/h2testCustomer")
    public String h2testCustomer(Model model) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "h2test";
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

            user = new User(email, encoder.encode(password), customer.getId());
            userRepository.save(user);
        }
        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(@RequestParam(required = false, defaultValue = "0") int delete, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (delete>-1){
            cart.removeItem(delete);
        }
        return "checkout";
    }

    @PostMapping("/checkout")
    public String addSubscriptions(@RequestParam long id, HttpSession session) {
        Subscription subscription = subscriptionRepository.findById(id).get();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        Child child = new Child(subscription);
        cart.addToCart(child);
        return "checkout";
    }

}

