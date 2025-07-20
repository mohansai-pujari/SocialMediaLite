package org.igniteKafka.project.skeleton;

import org.igniteKafka.project.model.PostStats;
import org.igniteKafka.project.model.User;

import java.util.List;
import java.util.UUID;

public interface RealTimeMonitoringService {

    void updatePostStats(UUID postId);

    PostStats getPostStats(UUID postId);

    int getFollowerCount(String userName);

    int getFollowingCount(String userName);

    List<User> getFollowerList(String userName);

    List<User> getFollowingList(String userName);

}
