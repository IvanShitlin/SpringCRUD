package ru.bootcamp.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bootcamp.springboot.dao.RoleDAO;
import ru.bootcamp.springboot.model.Role;
import ru.bootcamp.springboot.service.abstract_srv.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO dao;

    @Override
    public void addRole(Role role) {
        dao.addRole(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return dao.getRoleByName(roleName);
    }
}
