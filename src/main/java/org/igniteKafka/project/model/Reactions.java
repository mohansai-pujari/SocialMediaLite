package org.igniteKafka.project.model;

import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Reactions implements Serializable {
    private ReactionType reactionType;
    private long count;
    private Set<String> usersReacted = new HashSet<>();

    public void addReaction(String userId) {
        if (usersReacted.add(userId)) {
            count++;
        }
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Set<String> getUsersReacted() {
        return usersReacted;
    }

    public void setUsersReacted(Set<String> usersReacted) {
        this.usersReacted = usersReacted;
    }
}
