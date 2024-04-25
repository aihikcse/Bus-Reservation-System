package org.bus.service;

import org.bus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserService {
    public User addUser(User user);
    public User updateUser(User user);
    public User deleteUser(Integer userId);
    public User viewUser(Integer userId);
    public List<User> viewAllUser();

}
