package com.demo.service;

import com.demo.dto.UserRequest;
import com.demo.model.User;
import com.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest request) {
        return userRepository.save(User.build(0, request.getName(), request.getEmail(),
                request.getMobile(), request.getGender(), request.getAge(), request.getNationality()));
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findByUserId(id);
    }

}
