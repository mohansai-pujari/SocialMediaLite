package org.igniteKafka.project.skeleton;

import org.igniteKafka.project.model.PostStats;
import org.igniteKafka.project.model.User;

import java.util.List;

public interface RealTimeMonitoringService {

    void updatePostStats(String postId);

    PostStats getPostStats(String postId);

    int getFollowerCount(String userId);

    int getFollowingCount(String userId);

    List<User> getFollowerList(String userId);

    List<User> getFollowingList(String userId);

}
