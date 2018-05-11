package com.demo.controllers;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.services.GroupServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class GroupController {

    @Autowired
    private GroupServiceJpaImpl groupServiceJpaImpl;

    @RequestMapping(value = "/homeGroups", method = RequestMethod.GET)
    public String getAllGroups(ModelMap model) {
        Collection<Group> groups = groupServiceJpaImpl.findAll();
        model.addAttribute("groups", groups);
        return "/homeGroups";
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.POST, params = "groupId")
    public String deleteGroupById(@RequestParam("groupId") Long id) {
        groupServiceJpaImpl.deleteById(id);
        return "redirect:/homeGroups";
    }

    @RequestMapping(value = "/editGroup", method = RequestMethod.GET, params = "groupId")
    public ModelAndView editGroupView(@RequestParam("groupId") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("group", groupServiceJpaImpl.findById(id));
        return model;
    }

    @RequestMapping(value = "/editGroup", method = RequestMethod.POST)
    public String editGroupAction(@Valid Group group) {
        groupServiceJpaImpl.edit(group);
        return "redirect:/homeGroups";
    }

    @RequestMapping(value="/addGroup", method = RequestMethod.GET)
    public ModelAndView addGroupView(){
        ModelAndView modelAndView = new ModelAndView();
        Group group = new Group();
        modelAndView.addObject("group", group);
        return modelAndView;
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroupAction(@Valid Group group) {
        groupServiceJpaImpl.create(group);
        return "redirect:/homeGroups";
    }

}
