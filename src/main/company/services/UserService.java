package main.company.services;

import main.company.entities.User;

import java.util.List;

public interface UserService {


    /**
     * Returns a single User object by id.
     * @param userId
     * @return a single customer.
     */
    User getUser(Integer userId);

    /**
     * Returns all the User objects in the database.
     * @return List<User> of all user.
     */
    public List<User> getUserList();

    /**
     * Adds a new User object to the database.
     * @param user
     * @throws Exception
     */
    public void newUser(User user);

}
