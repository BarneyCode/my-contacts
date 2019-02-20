package zw.co.barney.mycontacts.service;

import zw.co.barney.mycontacts.model.User;

import java.util.List;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 9:38 AM
 */
public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();
    User getUser(Long id);

    User updateUser(User user);

    void deleteUser(Long id);
}
