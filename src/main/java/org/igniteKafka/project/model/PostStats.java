package org.igniteKafka.project.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostStats implements Serializable {
    @QuerySqlField(index = true)
    private UUID postId;

    @QuerySqlField
    private int totalComments;

    @QuerySqlField
    private int totalReactions;

    private Map<ReactionType, Integer> reactionBreakdown = new HashMap<>();

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    public int getTotalReactions() {
        return totalReactions;
    }

    public void setTotalReactions(int totalReactions) {
        this.totalReactions = totalReactions;
    }

    public Map<ReactionType, Integer> getReactionBreakdown() {
        return reactionBreakdown;
    }

    public void setReactionBreakdown(Map<ReactionType, Integer> reactionBreakdown) {
        this.reactionBreakdown = reactionBreakdown;
    }
}
