package zw.co.barney.mycontacts.service;

import org.springframework.stereotype.Service;
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
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        Iterable<Contact> contactIterable = this.contactRepository.findAll();
        List<Contact> contactList = new ArrayList<>();
        contactIterable.forEach(contactList::add);
        return contactList;
    }

    @Override
    public Contact getContact(Long id) {
        Optional<Contact> optionalContact = this.contactRepository.findById(id);
        if (!optionalContact.isPresent())
            throw new NoSuchElementException("User with user id" + id + " was not found");
        return optionalContact.get();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepository.deleteById(id);
    }
}
