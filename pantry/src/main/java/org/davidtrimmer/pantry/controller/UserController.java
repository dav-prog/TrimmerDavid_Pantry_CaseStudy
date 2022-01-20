package org.davidtrimmer.pantry.controller;

import org.davidtrimmer.pantry.dao.UserRepository;
import org.davidtrimmer.pantry.entity.User;
import org.davidtrimmer.pantry.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class UserController {

    private UserDetailsService userService;
    private UserRepository userRepository;

    @Autowired
//    public UserController(UserService theUserService) {
//        userService = theUserService;
//    }
    public UserController(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }

    @GetMapping("/list-users")
    public String findAll(Model theModel) {
        //get users from the db
//        List<User> theUsers = userService.getUsers();
        List<User> theUsers = userRepository.findAll();


        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "list-users";}

}
