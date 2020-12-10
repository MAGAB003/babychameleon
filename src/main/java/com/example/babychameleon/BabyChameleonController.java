package com.example.babychameleon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/test")
    public String tst() {
        return "test";
    }

}
