package zw.co.barney.mycontacts.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.barney.mycontacts.model.Address;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 1:03 PM
 */

public interface AddressRepository extends CrudRepository<Address,Long> {
}
