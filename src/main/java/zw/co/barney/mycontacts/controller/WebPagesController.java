package zw.co.barney.mycontacts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zw.co.barney.mycontacts.model.Address;
import zw.co.barney.mycontacts.model.Contact;
import zw.co.barney.mycontacts.model.User;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 11:51 AM
 */
@Controller
@Slf4j
public class WebPagesController {

    @GetMapping({"/login"})
    public String getLoginPage(Model model){
        return "login";
    }
    @GetMapping({"/register"})
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @GetMapping({"/contact/new"})
    public String getNewContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact/new";
    }
}

