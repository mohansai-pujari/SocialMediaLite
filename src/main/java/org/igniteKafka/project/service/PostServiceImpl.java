package org.igniteKafka.project.service;


import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.igniteKafka.project.kafka.PostEventProducer;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostEvent;
import org.igniteKafka.project.skeleton.PostService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostEventProducer producer = new PostEventProducer();
    private final IgniteCache<UUID, Post> postCache = Ignition.ignite().cache("POST_CACHE");

    public UUID createPost(String userId, String caption) {
        UUID id = UUID.randomUUID();
        Post post = new Post();
        post.setPostId(id);
        post.setUserId(userId);
        post.setCaption(caption);
        postCache.put(id, post);
        return id;
    }

    public void sendReaction(PostEvent event) {
        producer.send(event);
    }
}