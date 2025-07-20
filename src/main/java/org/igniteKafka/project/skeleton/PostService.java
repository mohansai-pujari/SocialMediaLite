package org.igniteKafka.project.skeleton;

import org.igniteKafka.project.model.PostEvent;

import java.util.UUID;

public interface PostService {
    public UUID createPost(String userId, String caption);
    public void sendReaction(PostEvent event);
}
