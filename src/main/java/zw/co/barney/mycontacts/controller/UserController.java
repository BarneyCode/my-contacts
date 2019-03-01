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

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        model.addAttribute("user", this.userService.getAllUsers());
        return "show";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));
        return "user/show";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

            User user1 = this.userService.createUser(user);

        return "redirect:/register?success";
    }
}
