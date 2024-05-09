package gr.aueb.cf.springauthsessiion5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login(Principal principal){
        return principal == null ? "Login" : "redirect:/dashboard";
    }
    @GetMapping("/")
    public String root(Principal principal){
        //return "redirect:/login";
        return principal == null ? "Login" : "redirect:/dashboard";
    }
}
