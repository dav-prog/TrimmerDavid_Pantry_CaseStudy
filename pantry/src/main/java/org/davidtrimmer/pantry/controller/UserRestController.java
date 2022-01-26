package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.entity.User;
import org.davidtrimmer.pantry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {


    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {return userService.getUsers();}

    // add mapping for GET /users/{userId}

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUser;
    }

    // add mapping for POST /users - add new user

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        // just in case they pass an id in JSON.. set id to 0
        // this is to force an insert of a new item.. instead of an update

        theUser.setId(0);

        userService.saveUser(theUser);

        return theUser;
    }

    // add mapping for PUT /users - update existing user

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

         userService.saveUser(theUser);

         return theUser;
    }

    // add mapping for DELETE /users/{userId}

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        User tempUser = userService.findById(userId);

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        userService.deleteUser(userId);

        return "Deleted user id - " + userId;
    }





}
