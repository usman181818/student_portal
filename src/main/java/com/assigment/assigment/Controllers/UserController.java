package com.assigment.assigment.Controllers;

import com.assigment.assigment.Models.User;
import com.assigment.assigment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5501")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        User user = userService.register(newUser);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        boolean isValid = userService.login(user.getUsername(), user.getPassword());
        if (isValid) {
            // Assuming userService can retrieve the user ID as well
            Long userId = userService.findUserIdByUsername(user.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User authenticated successfully");
            response.put("userId", userId);
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Invalid username or password");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
