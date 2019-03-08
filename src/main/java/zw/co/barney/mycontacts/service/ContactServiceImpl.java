package zw.co.barney.mycontacts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.co.barney.mycontacts.model.Contact;
import zw.co.barney.mycontacts.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 1:09 PM
 */
@Service
@Slf4j
@Transactional
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private UserService userService;

    public ContactServiceImpl(ContactRepository contactRepository, UserService userService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
    }

    @Override
    public Contact createContact(Contact contact) {
        contact.setUser(userService.getUserByUsername(this.getLoggedInUser()));
        return this.contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        Iterable<Contact> contactIterable = this.contactRepository.findAllByUser(userService.getUserByUsername(this.getLoggedInUser()));
        List<Contact> contactList = new ArrayList<>();
        contactIterable.forEach(contactList::add);
        return contactList;
    }

    @Override
    public Contact getContact(Long id) {
        Optional<Contact> optionalContact = this.contactRepository.findById(id);
        if (!optionalContact.isPresent())
            throw new NoSuchElementException("Contact with user id" + id + " was not found");
        if (!this.userService.getUserByUsername(this.getLoggedInUser()).equals(optionalContact.get().getUser()))
            throw new NoSuchElementException("you are not authorised to view this contact");
        return optionalContact.get();
    }

    @Override
    public Contact updateContact(Contact contact) {
        log.debug(contact.toString());
        return this.contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepository.deleteById(id);
    }


    private String getLoggedInUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        return principal.toString();
    }
}
