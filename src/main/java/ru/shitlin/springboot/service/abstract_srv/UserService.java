package ru.shitlin.springboot.service.abstract_srv;



import ru.shitlin.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void changeUser(long id, String name, String password) ;
    void deleteUser(long id);
    void insertUser(String name, String password);
    void addUser(User user);
    User getUser(long id);
    User getUserbyName(String name);
}
