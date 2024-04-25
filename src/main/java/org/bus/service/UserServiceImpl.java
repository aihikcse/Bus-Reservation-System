package org.bus.service;

import org.bus.model.User;
import org.bus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    @Override
    public User viewUser(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> viewAllUser() {
        return userRepository.findAll();
    }
}
