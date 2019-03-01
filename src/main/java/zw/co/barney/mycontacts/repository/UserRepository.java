package zw.co.barney.mycontacts.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.barney.mycontacts.model.User;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 9:38 AM
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
