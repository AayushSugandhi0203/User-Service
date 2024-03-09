package com.example.user.Service;
import com.example.user.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(int userId);

    List<User> getAllUsers();

}
