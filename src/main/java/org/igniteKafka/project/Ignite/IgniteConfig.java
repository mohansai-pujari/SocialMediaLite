package org.igniteKafka.project.Ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostStats;
import org.igniteKafka.project.model.User;

import java.util.UUID;

public class IgniteConfig {

    public static Ignite start() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Cache configs
        CacheConfiguration<String, User> userCache = new CacheConfiguration<>("USER_CACHE");
        userCache.setIndexedTypes(String.class, User.class);

        CacheConfiguration<UUID, Post> postCache = new CacheConfiguration<>("POST_CACHE");
        postCache.setIndexedTypes(UUID.class, Post.class);

        CacheConfiguration<String, PostStats> statsCache = new CacheConfiguration<>("POST_STATS_CACHE");
        statsCache.setIndexedTypes(String.class, PostStats.class);

        cfg.setCacheConfiguration(userCache, postCache, statsCache);
        return Ignition.start(cfg);
    }
}
