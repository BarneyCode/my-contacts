package zw.co.barney.mycontacts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.barney.mycontacts.model.User;
import zw.co.barney.mycontacts.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 11:22 AM
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> userIterable = this.userRepository.findAll();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);
        return userList;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (!optionalUser.isPresent())
            throw new NoSuchElementException("User with user id" + id + " was not found");
        return optionalUser.get();
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
