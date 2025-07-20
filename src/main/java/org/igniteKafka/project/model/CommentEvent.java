package org.igniteKafka.project.model;

import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.UUID;

public class CommentEvent implements Serializable {
    private UUID postId;
    private UUID userId;
    private String comment;

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
