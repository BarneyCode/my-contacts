package zw.co.barney.mycontacts.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.barney.mycontacts.model.Contact;
import zw.co.barney.mycontacts.model.User;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 1:03 PM
 */

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Iterable<Contact> findAllByUser(User user);
}
