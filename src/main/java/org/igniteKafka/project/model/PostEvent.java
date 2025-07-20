package org.igniteKafka.project.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostEvent implements Serializable {
    private String postId;
    private ReactionType reactionType;
    private String userId;

    public PostEvent(String postId, ReactionType type, String userId) {
        this.postId = postId;
        this.reactionType = type;
        this.userId = userId;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
