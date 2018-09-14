package ru.shitlin.springboot.dao;


import ru.shitlin.springboot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void changeUser(long id, String name, String password);
    User getUser(long id);
    User getUserbyName(String name);
    void deleteUser(long id);
    void insertUser(String name, String password);
    void addUser(User user);

}
