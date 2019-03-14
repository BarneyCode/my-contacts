package zw.co.barney.mycontacts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zw.co.barney.mycontacts.model.User;
import zw.co.barney.mycontacts.service.UserService;

import javax.validation.Valid;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 11:46 AM
 */
@Controller
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("error creating user " + user.toString());
            return "register";
        }
        this.userService.createUser(user);
        log.info("new user created " + user.toString());
        return "redirect:/register?success";
    }
}
