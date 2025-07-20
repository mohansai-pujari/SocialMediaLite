package org.igniteKafka.project.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PostStats implements Serializable {
    @QuerySqlField(index = true)
    private String postId;

    @QuerySqlField
    private int totalComments;

    @QuerySqlField
    private int totalReactions;

    private Map<ReactionType, Integer> reactionBreakdown = new HashMap<>();

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
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
