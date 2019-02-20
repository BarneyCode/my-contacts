package zw.co.barney.mycontacts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 11:51 AM
 */
@Controller
@Slf4j
public class WebPagesController {

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model){
        return "index";
    }


    @RequestMapping({"/login"})
    public String getLoginPage(Model model){
        return "login";
    }


}
