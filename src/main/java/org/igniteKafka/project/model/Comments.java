package org.igniteKafka.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comments implements Serializable {
    private UUID commentId;
    private UUID postId;
    private UUID userId;
    private String comment;
    private List<Comments> childComments = new ArrayList<>();

    public void addChildComment(Comments child) {
        childComments.add(child);
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

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

    public List<Comments> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<Comments> childComments) {
        this.childComments = childComments;
    }
}