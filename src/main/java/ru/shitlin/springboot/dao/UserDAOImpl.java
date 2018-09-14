package ru.shitlin.springboot.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shitlin.springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getAllUsers() {
        return (List<User>)manager.createQuery("From " + User.class.getSimpleName()).getResultList();
    }

    @Override
    public User getUserbyName(String name) {
        return (User) manager.createQuery("FROM " + User.class.getSimpleName() + " s where s.name = :username")
                .setParameter("username", name)
                .getSingleResult();
    }

    @Override
    public void changeUser(long id, String name, String password) {
        manager.createQuery("UPDATE " + User.class.getSimpleName() + " user SET user.name =:name, user.password =:password WHERE user.id =:userId")
                .setParameter("name", name)
                .setParameter("password", password)
                .setParameter("userId", id)
                .executeUpdate();

    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        manager.createQuery("DELETE FROM " + User.class.getSimpleName() + " c WHERE c.id =:userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

    @Override
    public void insertUser(String name, String password) {
        manager.persist(new User(name, password));
    }

    @Override
    public void addUser(User user) {
        manager.persist(user);
    }
}
