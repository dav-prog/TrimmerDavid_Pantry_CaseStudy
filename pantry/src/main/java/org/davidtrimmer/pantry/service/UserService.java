package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.entity.User;
import org.davidtrimmer.pantry.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    List<User> getUsers();

    User findById(int theId);

    void saveUser(User theUser);

    void deleteUser(int theId);

    void save(CrmUser crmUser);
}

