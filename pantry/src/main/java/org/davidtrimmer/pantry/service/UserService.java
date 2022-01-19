package org.davidtrimmer.pantry.service;

import org.davidtrimmer.pantry.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User findById(int theId);

    void saveUser(User theUser);

    void deleteUser(int theId);
}
