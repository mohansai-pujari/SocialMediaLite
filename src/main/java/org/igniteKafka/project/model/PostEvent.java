package org.igniteKafka.project.model;

import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.UUID;

public class PostEvent implements Serializable {
    private UUID postId;
    private ReactionType reactionType;
    private UUID userId;

    public PostEvent(UUID postId, ReactionType type, UUID userId) {
        this.postId = postId;
        this.reactionType = type;
        this.userId = userId;
    }


    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
