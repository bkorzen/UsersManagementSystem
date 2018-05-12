package com.demo.services;

import com.demo.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    Group findById(Long id);
    Group create(Group group);
    Group edit(Group group);
    void deleteById(Long id);
}
