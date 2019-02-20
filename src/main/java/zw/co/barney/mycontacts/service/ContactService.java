package zw.co.barney.mycontacts.service;

import zw.co.barney.mycontacts.model.Contact;

import java.util.List;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 1:09 PM
 */

public interface ContactService {

    Contact createContact(Contact contact);

    List<Contact> getAllContacts();
    Contact getContact(Long id);

    Contact updateContact(Contact contact);

    void deleteContact(Long id);
}
