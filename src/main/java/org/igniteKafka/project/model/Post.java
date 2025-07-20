package org.igniteKafka.project.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post implements Serializable {
    @QuerySqlField(index = true)
    private UUID postId;
    private UUID userId;
    private String caption;
    private String image;
    private String content;
    private List<Comments> comments = new ArrayList<>();
    private List<Reactions> reactions = new ArrayList<>();

    public void addComment(Comments comment) {
        comments.add(comment);
    }

    public void addReaction(Reactions reaction) {
        reactions.add(reaction);
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Reactions> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reactions> reactions) {
        this.reactions = reactions;
    }
}
