package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("subscriptions", (List<Subscription>) subscriptionRepository.findAll());
        return "subscriptions";
    }

    @GetMapping("/subscription/{id}")
    public String getSubscription(Model model, @PathVariable Long id) {
        model.addAttribute("subscription", subscriptionRepository.findById(id).get());
        return "subscriptiondetails";
    }

    @GetMapping("/login")
    public String login() {
        return "signIn";
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
        model.addAttribute("customers", (List<Customer>) customerRepository.findAll());
        return "h2test";
    }

    @GetMapping("/addnewcustomer")
    public String addnewcustomer() {
        return "addNewCustomer";
    }

    @GetMapping("/mysubscriptions")
    public String mySubscriptions(HttpServletRequest request, HttpSession session, Model model) {
        Customer customer = customerRepository.findByEmail(request.getUserPrincipal().getName()).get(0);
        List<Child> childrenList = customer.getChildren();
        session.setAttribute("childrenList", childrenList);
        session.setAttribute("customer", customer);

        return "mySubscriptions";
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
        return "signIn";
    }

    @GetMapping("/checkout")
    public String checkout(@RequestParam(required = false, defaultValue = "0") Long id,
                           @RequestParam(required = false, defaultValue = "-1") int delete,
                           HttpServletRequest request,
                           HttpSession session,
                           Model model) {
        Cart cart = (Cart) session.getAttribute("cart");

        if (id > 0) {
            Subscription subscription = subscriptionRepository.findById(id).orElse(null);
            if (subscription != null)
                model.addAttribute("subscription", subscription);
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            Child child = new Child(subscription);
            cart.addToCart(child);
        }

        if (delete > -1) {
            cart.removeItem(delete);
        }

        Customer customer = new Customer();
        if (request.getUserPrincipal() != null) {
            customer = customerRepository.findByEmail(request.getUserPrincipal().getName()).get(0);
            customer.getChildren().clear();
        }
        if (cart != null) {
            for (Child child : cart.cartItems) {
                customer.addChild(child);
            }
        }
        model.addAttribute("customer", customer);

        model.addAttribute("subscriptionslist", subscriptionRepository.findAll());

        return "checkout";
    }

    @PostMapping("/checkout")
    public String checkoutPost(@ModelAttribute Customer customer, HttpSession session) {
        Customer origCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (origCustomer == null) {
            return "checkout";
        }
        for (int i = 0; i < origCustomer.getChildren().size(); i++) {
            customer.addChild(origCustomer.getChildren().get(i));
        }
        customerRepository.save(customer);

        session.setAttribute("cart", null);

        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String confirmation() {
        return "confirmation";
    }

}

