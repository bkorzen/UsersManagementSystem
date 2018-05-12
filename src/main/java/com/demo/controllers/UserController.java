package com.demo.controllers;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.services.GroupServiceJpaImpl;
import com.demo.services.UserServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceJpaImpl userServiceJpaImpl;

    @Autowired
    private GroupServiceJpaImpl groupServiceJpaImpl;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        Collection<User> users = userServiceJpaImpl.findAll();
        model.addObject("users", users);
        return model;
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.POST, params = "userId")
    public String deleteUserById(@RequestParam("userId") Long id) {
        userServiceJpaImpl.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit", params = "userId")
    public ModelAndView editUserView(@RequestParam("userId") Long id) {
        ModelAndView model = new ModelAndView();
        List<Group> groups = groupServiceJpaImpl.findAll();
        model.addObject("user", userServiceJpaImpl.findById(id));
        model.addObject("groups", groups);
        return model;
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String editUserAction(@Valid User user) {
        userServiceJpaImpl.edit(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public ModelAndView addUserView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        List<Group> groups = groupServiceJpaImpl.findAll();

        modelAndView.addObject("user", user);
        modelAndView.addObject("groups", groups);
        return modelAndView;
    }

    @PostMapping(value = "/users/add", params = "groupsList[]")
    public String addUserAction(@Valid User user, @RequestParam("groupsList[]") Long[] groupsIds) {
        for (Long id : groupsIds) {
            Group group = groupServiceJpaImpl.findById(id);
            group.getUsers().add(user);
            user.getGroups().add(group);
        }
        userServiceJpaImpl.create(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/show", params = "userId")
    public ModelAndView getUserView(@RequestParam("userId") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userServiceJpaImpl.findById(id));
        return model;
    }
}
