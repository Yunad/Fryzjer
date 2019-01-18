package com.fryzjerappbackend.service;

import com.auth.validator.UserValidator;
import com.fryzjerappbackend.exception.CustomError;
import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CustomError customError;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("yes") // set to YES
    private Boolean requireActivation;

    public final String CURRENT_USER_KEY = "CURRENT_USER";

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isUserExistInDatabase(String email) {
        final Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.isPresent();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public User registerNewUserAccount(User user) {
        User dbUser = new User();
        dbUser.setEmail(user.getEmail());
        userValidator.validate(user, customError);
        dbUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        dbUser.setName(user.getName());
        dbUser.setLastName(user.getLastName());
        dbUser.setRoleId(user.getRoleId());
        userRepository.save(dbUser);
        return dbUser;
    }

    public List<User> getUserByRoleId(Long id) {
        return userRepository.findUserByRoleId(id);
    }

    //    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(username);
//
//        if (!user.isPresent()) {
//            throw new UsernameNotFoundException(username);
//        }
//        final User user1 = user.get();
//        final Optional<Role> roleById = roleRepository.findRoleById(user1.getRoleId());
//        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(roleById.get().getName());
//        return new org.springframework.security.core.userdetails.User(
//                user1.getName(),
//                user1.getPassword(),
//                true, // enabled. Use whatever condition you like
//                true, // accountNonExpired. Use whatever condition you like
//                true, // credentialsNonExpired. Use whatever condition you like
//                true, // accountNonLocked. Use whatever condition you like
//                auth);
//    }
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<com.fryzjerappbackend.model.User> applicationUser = userRepository.findByEmail(email);
//        if (applicationUser.isPresent()) {
//            throw new UsernameNotFoundException(email);
//        }
//        final com.fryzjerappbackend.model.User user = applicationUser.get();
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), applicationUser.get().getEmail(), emptyList());
//    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = getUserByEmail(email);
        final Role roleById = roleService.getRoleById(user.get().getRoleId());
        final String name = roleById.getName();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(name));

        return new org.springframework.security.core.userdetails.User(user.get().getName(), user.get().getPassword(), grantedAuthorities);
    }
}

