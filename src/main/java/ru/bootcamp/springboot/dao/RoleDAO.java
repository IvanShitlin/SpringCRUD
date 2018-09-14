package ru.bootcamp.springboot.dao;

import ru.bootcamp.springboot.model.Role;

public interface RoleDAO {
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
