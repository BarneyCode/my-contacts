package zw.co.barney.mycontacts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.co.barney.mycontacts.model.AuthGroup;
import zw.co.barney.mycontacts.model.User;
import zw.co.barney.mycontacts.repository.AuthGroupRepository;
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
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthGroupRepository authGroupRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AuthGroup authGroup = new AuthGroup("USER",user.getUsername());
        this.authGroupRepository.save(authGroup);
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
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
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
