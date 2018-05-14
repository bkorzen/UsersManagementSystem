package com.demo.services;

import com.demo.model.Group;
import com.demo.model.User;
import com.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User user = userRepo.findOne(id);
        Set<Group> groups = user.getGroups();
        for (Group g : groups) {
            g.getUsers().remove(user);
        }
//        user.getGroups().removeAll(user.getGroups());
        userRepo.delete(user);
    }

}
