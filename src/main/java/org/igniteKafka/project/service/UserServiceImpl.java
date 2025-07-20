package org.igniteKafka.project.service;

import org.igniteKafka.project.dao.UserDao;
import org.igniteKafka.project.model.User;
import org.igniteKafka.project.skeleton.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<Object> createUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public ResponseEntity<Object> followUser(String userId, String targetUserId) {
        User user = userDao.getUser(userId);
        User target = userDao.getUser(targetUserId);

        if (user != null && target != null) {
            user.getFollowing().add(targetUserId);
            target.getFollowers().add(userId);

            userDao.updateUser(user);
            userDao.updateUser(target);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userId + " followed " + targetUserId);
    }

    @Override
    public List<User> getFollowers(String userId) {
        User user = userDao.getUser(userId);
        return user == null ? new ArrayList<>() : userDao.getUsersByIds(user.getFollowers());
    }

    @Override
    public List<User> getFollowing(String userId) {
        User user = userDao.getUser(userId);
        return user == null ? new ArrayList<>() : userDao.getUsersByIds(user.getFollowing());
    }

    @Override
    public List<User> getFeedUsers(String userName) {
        User user = userDao.getUser(userName);
        Set<String> visibleUserNames = new HashSet<>();
        if (user != null) {
            visibleUserNames.add(userName);
            visibleUserNames.addAll(user.getFollowing());
        }
        return userDao.getUsersByIds(visibleUserNames);
    }
}
