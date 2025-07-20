package org.igniteKafka.project.model;

import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;

public class CommentEvent implements Serializable {
    private String postId;
    private String userId;
    private String comment;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
