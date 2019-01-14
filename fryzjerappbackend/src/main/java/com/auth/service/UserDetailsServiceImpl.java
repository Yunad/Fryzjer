package com.auth.service;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {


        ArrayList<GrantedAuthority> authos = new ArrayList<GrantedAuthority>();
        authos.add(new GrantedAuthority() {

            /**
             *
             */
            private static final long serialVersionUID = 3275308160303374393L;

            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
        try {
            for (User usa : userService.getAllUsers()) {
                System.out.println(usa.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new org.springframework.security.core.userdetails.User("asd", "asd", true, true, true, true, authos);
    }
}
