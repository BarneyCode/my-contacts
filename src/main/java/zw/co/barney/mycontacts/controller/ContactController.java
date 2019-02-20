package zw.co.barney.mycontacts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zw.co.barney.mycontacts.service.ContactService;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 1:23 PM
 */
@Controller
@Slf4j
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String getAllCustomers(Model model){
        model.addAttribute("contacts",this.contactService.getAllContacts());
        return "contact/contactlist";
    }

    @RequestMapping("/contact/{id}")
    public String getCustomer(@PathVariable Long id, Model model){
        model.addAttribute("contact",this.contactService.getContact(id));
        return "contact/contact";
    }
}
