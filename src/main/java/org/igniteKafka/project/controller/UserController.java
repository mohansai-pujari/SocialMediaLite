package org.igniteKafka.project.controller;

import org.igniteKafka.project.model.User;
import org.igniteKafka.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @PostMapping("/{userId}/follow/{targetUserId}")
    public ResponseEntity<Object> followUser(@PathVariable String userName, @PathVariable String targetUserName) {
        return userServiceImpl.followUser(userName, targetUserName);
    }

    @GetMapping("/{userId}/followers")
    public List<User> getFollowers(@PathVariable String userName) {
        return userServiceImpl.getFollowers(userName);
    }

    @GetMapping("/{userId}/following")
    public List<User> getFollowing(@PathVariable String userName) {
        return userServiceImpl.getFollowing(userName);
    }

    @GetMapping("/{userId}/feed-users")
    public List<User> getFeedUsers(@PathVariable String userName) {
        return userServiceImpl.getFeedUsers(userName);
    }
}
