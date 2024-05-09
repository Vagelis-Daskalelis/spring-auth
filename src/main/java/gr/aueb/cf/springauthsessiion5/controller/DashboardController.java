package gr.aueb.cf.springauthsessiion5.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
