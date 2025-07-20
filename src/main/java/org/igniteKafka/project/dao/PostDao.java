package org.igniteKafka.project.dao;

import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostStats;

public class PostDao {
    public Post getPost(String postId) {
        return new Post();
    }

    public void saveStats(PostStats stats) {
    }

    public PostStats getStats(String postId) {
        return new PostStats();
    }
}
