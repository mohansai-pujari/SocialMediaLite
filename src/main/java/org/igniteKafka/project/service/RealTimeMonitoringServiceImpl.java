package org.igniteKafka.project.service;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.igniteKafka.project.enums.ReactionType;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostStats;
import org.igniteKafka.project.model.Reactions;
import org.igniteKafka.project.model.User;
import org.igniteKafka.project.skeleton.RealTimeMonitoringService;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RealTimeMonitoringServiceImpl implements RealTimeMonitoringService {

    private final Ignite ignite = Ignition.ignite();
    private final IgniteCache<String, User> userCache = ignite.cache("USER_CACHE");
    private final IgniteCache<String, PostStats> postStatsCache = ignite.cache("POST_STATS_CACHE");

    @Override
    public void updatePostStats(String postId) {
        IgniteCache<String, Post> postCache = ignite.cache("POST_CACHE");
        IgniteCache<String, PostStats> postStatsCache = ignite.cache("POST_STATS_CACHE");

        Post post = postCache.get(postId);
        if (post == null) return;

        PostStats stats = new PostStats();
        stats.setPostId(postId);

        if (post.getComments() != null)
            stats.setTotalComments(post.getComments().size());

        int totalReactions = 0;
        Map<ReactionType, Integer> reactionMap = new HashMap<>();

        if (post.getReactions() != null) {
            for (Reactions reaction : post.getReactions()) {
                ReactionType type = reaction.getReactionType();
                int count = reaction.getUsersReacted() != null ? reaction.getUsersReacted().size() : 0;

                reactionMap.put(type, reactionMap.getOrDefault(type, 0) + count);
                totalReactions += count;
            }
        }

        stats.setTotalReactions(totalReactions);
        stats.setReactionBreakdown(reactionMap);

        postStatsCache.put(postId, stats);
    }


    @Override
    public PostStats getPostStats(String postId) {
        return postStatsCache.get(postId);
    }

    @Override
    public int getFollowerCount(String userId) {
        User user = userCache.get(userId);
        return (user != null && user.getFollowers() != null) ? user.getFollowers().size() : 0;
    }

    @Override
    public int getFollowingCount(String userId) {
        User user = userCache.get(userId);
        return (user != null && user.getFollowing() != null) ? user.getFollowing().size() : 0;
    }

    @Override
    public List<User> getFollowerList(String userId) {
        User user = userCache.get(userId);
        if (user == null || user.getFollowers() == null) return new ArrayList<>();

        Set<String> followerIds = new HashSet<>(user.getFollowers());
        return followerIds.stream()
                .map(userCache::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getFollowingList(String userId) {
        User user = userCache.get(userId);
        if (user == null || user.getFollowing() == null) return new ArrayList<>();

        Set<String> followingIds = new HashSet<>(user.getFollowing());
        return followingIds.stream()
                .map(userCache::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
