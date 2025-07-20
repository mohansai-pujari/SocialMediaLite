package org.igniteKafka.project.controller;


import org.igniteKafka.project.enums.ReactionType;
import org.igniteKafka.project.model.Post;
import org.igniteKafka.project.model.PostEvent;
import org.igniteKafka.project.skeleton.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public String createPost(@RequestParam UUID userId, @RequestParam String caption) {
        UUID postId = postService.createPost(userId, caption);
        return "Post created with ID: " + postId;
    }

    @PostMapping("/{postId}/react")
    public String react(@PathVariable UUID postId,
                        @RequestParam ReactionType type,
                        @RequestParam UUID userId) {
        PostEvent event = new PostEvent(postId, type, userId);
        postService.sendReaction(event);
        return "Reaction submitted";
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable UUID postId){
        return postService.getPost(postId);
    }
}