package org.igniteKafka.project.service;

import org.igniteKafka.project.dao.PostDao;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostEvent;
import org.igniteKafka.project.skeleton.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    public UUID createPost(UUID userId, String caption) {
        UUID id = UUID.randomUUID();
        Post post = new Post();
        post.setPostId(id);
        post.setUserId(userId);
        post.setCaption(caption);
        return postDao.createPost(id, post);
    }

    public void sendReaction(PostEvent event) {
        postDao.sendReaction(event);
    }

    public Post getPost(UUID postId){
        return postDao.getPost(postId);
    }
}