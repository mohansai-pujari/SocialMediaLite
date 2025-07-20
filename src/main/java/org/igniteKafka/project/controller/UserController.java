package org.igniteKafka.project.controller;

import org.igniteKafka.project.model.User;
import org.igniteKafka.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public String createUser(@RequestBody User user) {
        userServiceImpl.createUser(user);
        return "User created";
    }

    @PostMapping("/{userId}/follow/{targetUserId}")
    public String followUser(@PathVariable String userId, @PathVariable String targetUserId) {
        userServiceImpl.followUser(userId, targetUserId);
        return userId + " followed " + targetUserId;
    }

    @GetMapping("/{userId}/followers")
    public List<User> getFollowers(@PathVariable String userId) {
        return userServiceImpl.getFollowers(userId);
    }

    @GetMapping("/{userId}/following")
    public List<User> getFollowing(@PathVariable String userId) {
        return userServiceImpl.getFollowing(userId);
    }

    @GetMapping("/{userId}/feed-users")
    public List<User> getFeedUsers(@PathVariable String userId) {
        return userServiceImpl.getFeedUsers(userId);
    }
}
