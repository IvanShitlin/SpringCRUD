package ru.shitlin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shitlin.springboot.model.Role;
import ru.shitlin.springboot.model.User;
import ru.shitlin.springboot.service.abstract_srv.RoleService;
import ru.shitlin.springboot.service.abstract_srv.UserService;


import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String homePage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public ModelAndView editUser(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject(userService.getUserbyName(principal.getName()));
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam(value = "id")long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String addUserGet() {
        return "login";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addUserPost(@RequestParam(value = "username") String name,
                              @RequestParam(value = "password") String password) {
        Role role = roleService.getRoleByName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User(name, password);
        user.setRoles(roles);
        userService.addUser(user);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit")
    public ModelAndView editUser(long id) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject(userService.getUser(id));
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String editUserPost(@RequestParam(value = "id") long id,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "password") String password,
                               ModelMap modelMap) {
        userService.changeUser(id, name, password);

        return "redirect:/admin";

    }


}
