package com.demo.controllers;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.services.GroupServiceJpaImpl;
import com.demo.services.UserServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;


@Controller
public class GroupController {

    @Autowired
    private GroupServiceJpaImpl groupServiceJpaImpl;

    @Autowired
    private UserServiceJpaImpl userServiceJpaImpl;

    @GetMapping(value = "/groups")
    public ModelAndView getAllGroups() {
        ModelAndView model = new ModelAndView();
        List<Group> groups = groupServiceJpaImpl.findAll();
        model.addObject("groups", groups);
        return model;
    }

    @PostMapping(value = "/groups/delete", params = "groupId")
    public String deleteGroupById(@RequestParam("groupId") Long id) {
        groupServiceJpaImpl.deleteById(id);
        return "redirect:/groups";
    }

    @GetMapping(value = "/groups/edit", params = "groupId")
    public ModelAndView editGroupView(@RequestParam("groupId") Long id) {
        ModelAndView model = new ModelAndView();
        List<User> users = userServiceJpaImpl.findAll();
        model.addObject("group", groupServiceJpaImpl.findById(id));
        model.addObject("users", users);
        return model;
    }

    @PostMapping(value = "/groups/edit", params = "usersList[]")
    public String editGroupAction(@Valid Group group, @RequestParam("usersList[]") Long[] usersIds) {
        Group currentGroup = groupServiceJpaImpl.findById(group.getId());
        Set<User> users = currentGroup.getUsers();

        List<Long> usersIdsList = Arrays.asList(usersIds);
        List<Long> groupUsersIds = new ArrayList<>();

        for (User user : users) {
            groupUsersIds.add(user.getId());
            if (!usersIdsList.contains(user.getId())) {
                user.getGroups().remove(currentGroup);
                userServiceJpaImpl.edit(user);
            }
        }
        for (Long id : usersIdsList) {
            if (!groupUsersIds.contains(id)) {
                User user = userServiceJpaImpl.findById(id);
                user.getGroups().add(currentGroup);
                userServiceJpaImpl.edit(user);
            }
        }
        groupServiceJpaImpl.edit(group);
        return "redirect:/groups";
    }

    @GetMapping(value="/groups/add")
    public ModelAndView addGroupView(){
        ModelAndView model = new ModelAndView();
        List<User> users = userServiceJpaImpl.findAll();
        Group group = new Group();
        model.addObject("group", group);
        model.addObject("users", users);
        return model;
    }

    @PostMapping(value = "/groups/add", params = "usersList[]")
    public String addGroupAction(@Valid Group group, @RequestParam("usersList[]") Long[] usersIds) {
        for (Long id : usersIds) {
            User user = userServiceJpaImpl.findById(id);
            user.getGroups().add(group);
            group.getUsers().add(user);
        }
        groupServiceJpaImpl.create(group);
        return "redirect:/groups";
    }

    @GetMapping(value = "/groups/show", params = "groupId")
    public ModelAndView getGroupView(@RequestParam("groupId") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("group", groupServiceJpaImpl.findById(id));
        return model;
    }
}
