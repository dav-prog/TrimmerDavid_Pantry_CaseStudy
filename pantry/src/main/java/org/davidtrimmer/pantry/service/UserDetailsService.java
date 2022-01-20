package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.entity.User;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDetailsService {
//
//    UserDetails loadUserByUsername(String userName);

    List<User> getUsers();

    User findById(int theId);

    void saveUser(User theUser);

    void deleteUser(int theId);
}
