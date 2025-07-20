package org.igniteKafka.project.dao;

import org.apache.ignite.IgniteCache;
import org.igniteKafka.project.kafka.PostEventProducer;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PostDao {

    private final PostEventProducer producer = new PostEventProducer();

    @Autowired
    private IgniteCache<UUID, Post> postCache;

    public UUID createPost(UUID id, Post post) {
        postCache.put(id, post);
        return id;
    }

    public void sendReaction(PostEvent event) {
        producer.send(event);
    }

    public Post getPost(UUID postId) {
        return postCache.get(postId) == null ? new Post() : postCache.get(postId);
    }
}
