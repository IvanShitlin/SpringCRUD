package ru.bootcamp.springboot.service.abstract_srv;


import ru.bootcamp.springboot.model.Role;

public interface RoleService {
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
