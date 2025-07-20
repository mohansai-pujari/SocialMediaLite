package org.igniteKafka.project.kafka;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.igniteKafka.project.enums.ReactionType;
import org.igniteKafka.project.model.PostEvent;
import org.igniteKafka.project.model.PostStats;

import java.util.Map;

public class PostEventConsumer {

    public void consume(PostEvent event) {
        Ignite ignite = Ignition.ignite();
        IgniteCache<String, PostStats> statsCache = ignite.cache("POST_STATS_CACHE");

        PostStats stats = statsCache.get(event.getPostId());
        if (stats == null) {
            stats = new PostStats();
            stats.setPostId(event.getPostId());
        }

        stats.setTotalReactions(stats.getTotalReactions() + 1);
        Map<ReactionType, Integer> breakdown = stats.getReactionBreakdown();
        breakdown.put(event.getReactionType(), breakdown.getOrDefault(event.getReactionType(), 0) + 1);
        stats.setReactionBreakdown(breakdown);

        statsCache.put(event.getPostId(), stats);
    }
}
