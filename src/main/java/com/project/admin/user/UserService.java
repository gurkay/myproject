package com.project.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.entity.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {

        return userRepository.save(user);
    }

    public List<User> listAllUsers() {

        return (List<User>) userRepository.findAll();
    }
}
