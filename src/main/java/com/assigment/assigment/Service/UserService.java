package com.assigment.assigment.Service;

import com.assigment.assigment.Models.User;
import com.assigment.assigment.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User newUser) {
        // Check if a user with the same username already exists
        User existingUser = userRepository.findByUsername(newUser.getUsername());
        if (existingUser != null) {
            // Handle the case where a user with the same username already exists.
            // This could be throwing an exception or returning null.
            // Example: throw new RuntimeException("User with username " + newUser.getUsername() + " already exists.");
            return null; // Here, returning null for simplicity. Adjust based on your error handling strategy.
        }

        // If no existing user, save and return the new user.
        // In real-world, you should encrypt the password here
        return userRepository.save(newUser);
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // In a real app, generate a token here
            return true;
        }
        return false;
    }

    public Long findUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getId();  // Assuming User class has an getId() method
        }
        return null;  // Or handle this case as needed
    }
}
