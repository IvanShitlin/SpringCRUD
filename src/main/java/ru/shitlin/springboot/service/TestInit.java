package ru.shitlin.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import ru.shitlin.springboot.model.Role;
import ru.shitlin.springboot.model.User;
import ru.shitlin.springboot.service.abstract_srv.RoleService;
import ru.shitlin.springboot.service.abstract_srv.UserService;

import java.util.HashSet;
import java.util.Set;

public class TestInit {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @SuppressWarnings("deprecation")
    @Autowired
    private NoOpPasswordEncoder passwordEncoder;

    private void init() {
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleService.addRole(admin);
        roleService.addRole(user);
        User ad = new User();
        User us = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(user);
        us.setName("user");
        us.setPassword("user");
        us.setRoles(roles);
        userService.addUser(us);
        ad.setName("admin");
        ad.setPassword("admin");
        roles.add(admin);
        ad.setRoles(roles);
        userService.addUser(ad);
    }
}
