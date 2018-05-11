package com.demo.controllers;

import com.demo.model.User;
import com.demo.services.UserServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserServiceJpaImpl userServiceJpaImpl;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAllUsers(ModelMap model) {
        Collection<User> users = userServiceJpaImpl.findAll();
        model.addAttribute("users", users);
        return "/home";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, params = "userId")
    public String deleteUserById(@RequestParam("userId") Long id) {
        userServiceJpaImpl.deleteById(id);
        return "redirect:/home";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET, params = "userId")
    public ModelAndView editUserView(@RequestParam("userId") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userServiceJpaImpl.findById(id));
        return model;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUserAction(@Valid User user) {
        userServiceJpaImpl.edit(user);
        return "redirect:/home";
    }

    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public ModelAndView addUserView(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserAction(@Valid User user) {
        userServiceJpaImpl.create(user);
        return "redirect:/home";
    }

}
