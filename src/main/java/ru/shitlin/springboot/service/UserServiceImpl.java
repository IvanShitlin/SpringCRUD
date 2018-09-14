package ru.shitlin.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shitlin.springboot.dao.UserDAO;
import ru.shitlin.springboot.model.User;
import ru.shitlin.springboot.service.abstract_srv.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void changeUser(long id, String name, String password) {
        dao.changeUser(id, name, password);
    }

    @Override
    public void deleteUser(long id) {
        dao.deleteUser(id);

    }
    @Override
    public User getUserbyName(String name) {
        return dao.getUserbyName(name);
    }

    @Override
    public void insertUser(String name, String password) {
        dao.insertUser(name, password);
    }

    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
}
