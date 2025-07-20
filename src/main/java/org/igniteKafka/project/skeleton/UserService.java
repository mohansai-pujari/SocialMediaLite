package org.igniteKafka.project.skeleton;

import org.igniteKafka.project.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    ResponseEntity<Object> createUser(User user);
    ResponseEntity<Object> followUser(String userName, String targetUserName);
    List<User> getFollowers(String userName);
    List<User> getFollowing(String userName);
    List<User> getFeedUsers(String userName);
}
