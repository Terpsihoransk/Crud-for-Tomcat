package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    User getUserById(int id);
    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
}

