package zw.co.barney.mycontacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zw.co.barney.mycontacts.service.UserService;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 11:46 AM
 */
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public String getAllUsers(Model model){
        model.addAttribute("user",this.userService.getAllUsers());
        return "show";
    }

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model){
        model.addAttribute("user",this.userService.getUser(id));
        return "show";
    }
}
