package zw.co.barney.mycontacts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zw.co.barney.mycontacts.model.Contact;
import zw.co.barney.mycontacts.service.ContactService;

import javax.validation.Valid;

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


    @GetMapping("/contact")
    public String getAllContacts(Model model){
        model.addAttribute("contacts",this.contactService.getAllContacts());
        return "contact/contactlist";
    }

    @GetMapping("/contact/{id}")
    public String getContact(@PathVariable Long id, Model model){
        model.addAttribute("contact",this.contactService.getContact(id));
        return "contact/contact";
    }

    @PostMapping("/contact/new")
    public String saveContact(@Valid @ModelAttribute Contact contact, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "contact/new";
        }
        this.contactService.createContact(contact);
        return "redirect:/contact/" + contact.getId();
    }

    @PutMapping("/contact/update")
    public String updateContact(@RequestBody Contact contact){
        this.contactService.updateContact(contact);
        return "redirect:/contact/" + contact.getId();
    }
}
