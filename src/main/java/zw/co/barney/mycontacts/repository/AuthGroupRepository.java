package zw.co.barney.mycontacts.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.barney.mycontacts.model.AuthGroup;

import java.util.List;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/21/2019 10:50 AM
 */

public interface AuthGroupRepository extends CrudRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
