package ru.shitlin.springboot.service.abstract_srv;


import ru.shitlin.springboot.model.Role;

public interface RoleService {
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
