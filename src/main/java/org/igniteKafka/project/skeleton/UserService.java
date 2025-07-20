package org.igniteKafka.project.skeleton;

import org.igniteKafka.project.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void followUser(String userId, String targetUserId);
    List<User> getFollowers(String userId);
    List<User> getFollowing(String userId);
    List<User> getFeedUsers(String userId);
}
