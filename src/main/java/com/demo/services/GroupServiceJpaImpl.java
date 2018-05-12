package com.demo.services;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class GroupServiceJpaImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepo;

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepo.findOne(id);
    }

    @Override
    public Group create(Group group) {
        return groupRepo.save(group);
    }

    @Override
    public Group edit(Group group) {
        return groupRepo.save(group);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Group group = groupRepo.findOne(id);
        Set<User> users = group.getUsers();
        for (User u : users) {
            u.getGroups().remove(group);
        }
        groupRepo.delete(group);
    }
}
