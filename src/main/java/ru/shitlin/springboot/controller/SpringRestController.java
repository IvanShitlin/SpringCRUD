package ru.shitlin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shitlin.springboot.model.User;
import ru.shitlin.springboot.service.abstract_srv.RoleService;
import ru.shitlin.springboot.service.abstract_srv.UserService;

import java.util.List;

@RestController
public class SpringRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/api/users")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> putUser(@PathVariable(name = "id") long id,
                                        @RequestBody User user) {
        userService.changeUser(id, user.getName(), user.getPassword());
        return ResponseEntity.ok().body(userService.getUser(id));
    }

}
