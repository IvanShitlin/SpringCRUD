package ru.bootcamp.springboot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bootcamp.springboot.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void addRole(Role role) {
        manager.persist(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return (Role)manager.createQuery("FROM " + Role.class.getSimpleName() + " r WHERE r.role = :role")
                .setParameter("role", roleName)
                .getSingleResult();
    }
}
