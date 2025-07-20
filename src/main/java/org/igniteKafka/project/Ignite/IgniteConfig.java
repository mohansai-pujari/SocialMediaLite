package org.igniteKafka.project.Ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostStats;
import org.igniteKafka.project.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class IgniteConfig {

    @Bean
    public Ignite customIgnite() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        CacheConfiguration<String, User> userCache = new CacheConfiguration<>("USER_CACHE");
        userCache.setIndexedTypes(String.class, User.class);

        CacheConfiguration<UUID, Post> postCache = new CacheConfiguration<>("POST_CACHE");
        postCache.setIndexedTypes(UUID.class, Post.class);

        CacheConfiguration<UUID, PostStats> statsCache = new CacheConfiguration<>("POST_STATS_CACHE");
        statsCache.setIndexedTypes(UUID.class, PostStats.class);

        cfg.setCacheConfiguration(userCache, postCache, statsCache);
        cfg.setIgniteInstanceName("social-media-lite");
        cfg.setPeerClassLoadingEnabled(true); // optional

        return Ignition.start(cfg);
    }

    @Bean
    public IgniteCache<UUID, Post> postCache(Ignite ignite) {
        return customIgnite().getOrCreateCache("POST_CACHE");
    }

    @Bean
    public IgniteCache<String, User> userCache(Ignite ignite) {
        return customIgnite().getOrCreateCache("USER_CACHE");
    }

    @Bean
    public IgniteCache<UUID, PostStats> postStatsCache(Ignite ignite) {
        return customIgnite().getOrCreateCache("POST_STATS_CACHE");
    }
}
