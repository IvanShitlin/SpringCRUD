package ru.shitlin.springboot.dao;

import ru.shitlin.springboot.model.Role;

public interface RoleDAO {
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
