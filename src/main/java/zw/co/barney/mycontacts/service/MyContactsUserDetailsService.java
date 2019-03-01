package zw.co.barney.mycontacts.service;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.co.barney.mycontacts.configuration.MyContactsUserPrincipal;
import zw.co.barney.mycontacts.model.AuthGroup;
import zw.co.barney.mycontacts.model.User;
import zw.co.barney.mycontacts.repository.AuthGroupRepository;
import zw.co.barney.mycontacts.repository.UserRepository;

import java.util.List;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/21/2019 10:24 AM
 */
@Service
public class MyContactsUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public MyContactsUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username + " not found!");
        List<AuthGroup> authGroupList = this.authGroupRepository.findByUsername(username) ;
        return new MyContactsUserPrincipal(user,authGroupList);
    }
}
