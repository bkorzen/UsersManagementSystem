package com.demo.services;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.repositories.GroupRepository;
import com.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void deleteById(Long id) {
        groupRepo.delete(id);
    }
}
