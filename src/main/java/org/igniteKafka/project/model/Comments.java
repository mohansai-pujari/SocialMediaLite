package org.igniteKafka.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comments implements Serializable {
    private String commentId;
    private String postId;
    private String userId;
    private String comment;
    private List<Comments> childComments = new ArrayList<>();

    public void addChildComment(Comments child) {
        childComments.add(child);
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

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

    public List<Comments> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<Comments> childComments) {
        this.childComments = childComments;
    }
}