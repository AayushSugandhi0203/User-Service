package com.example.user.ServiceImpl;
import com.example.user.CustomException.CustomExceptions;
import com.example.user.Entity.User;
import com.example.user.Repository.UserRepository;
import com.example.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(int userId)  {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow(() -> new CustomExceptions("No user found",new NoSuchElementException()));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
