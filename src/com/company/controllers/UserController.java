package com.company.controllers;

import com.company.entities.User;
import com.company.services.UserService;

public class UserController {



    public User getUser(Integer id) throws InvalidInputException {
        return userService.getUser(id);
    }


    public void add(User user) {
        System.out.println(user);
        userService.add(user);
    }
}
