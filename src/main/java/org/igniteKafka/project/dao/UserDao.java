package org.igniteKafka.project.dao;

import org.apache.ignite.IgniteCache;
import org.igniteKafka.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.cache.Cache;
import java.util.*;
import java.util.stream.Collectors;

public class UserDao {

    @Autowired
    private IgniteCache<String, User> userCache;

    public void saveUser(User user) {
        userCache.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return userCache.get(userId);
    }

    public void updateUser(User user) {
        userCache.put(user.getUserId(), user);
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

    public List<User> getFollowers(String userId) {
        User user = userCache.get(userId);
        if (user == null || user.getFollowers() == null) return new ArrayList<>();
        return getUsersByIds(user.getFollowers());
    }

    public List<User> getFollowing(String userId) {
        User user = userCache.get(userId);
        if (user == null || user.getFollowing() == null) return new ArrayList<>();
        return getUsersByIds(user.getFollowing());
    }
}
