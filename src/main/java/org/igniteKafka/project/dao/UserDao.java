package org.igniteKafka.project.dao;

import org.apache.ignite.IgniteCache;
import org.igniteKafka.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.cache.Cache;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserDao {

    @Autowired
    private IgniteCache<String, User> userCache;

    public ResponseEntity<Object> saveUser(User user) {
        if(userCache.containsKey(user.getUserName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserName Already Exist");
        }
        user.setUserId(UUID.randomUUID());
        userCache.put(user.getUserName(), user);
        return ResponseEntity.status(HttpStatus.OK).body("User Created");
    }

    public User getUser(String userName) {
        return userCache.get(userName);
    }

    public void updateUser(User user) {
        userCache.put(user.getUserName(), user);
    }

    public List<User> getUsersByIds(Set<String> ids) {
        if (ids == null) return new ArrayList<>();
        return ids.stream()
                .map(userCache::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (Cache.Entry<String, User> entry : userCache) {
            users.add(entry.getValue());
        }
        return users;
    }

    public List<User> getFollowers(String userName) {
        User user = userCache.get(userName);
        if (user == null || user.getFollowers() == null) return new ArrayList<>();
        return getUsersByIds(user.getFollowers());
    }

    public List<User> getFollowing(String userName) {
        User user = userCache.get(userName);
        if (user == null || user.getFollowing() == null) return new ArrayList<>();
        return getUsersByIds(user.getFollowing());
    }
}
