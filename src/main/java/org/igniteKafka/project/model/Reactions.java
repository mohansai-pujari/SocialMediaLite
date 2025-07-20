package org.igniteKafka.project.model;

import org.igniteKafka.project.enums.ReactionType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Reactions implements Serializable {
    private ReactionType reactionType;
    private long count;
    private Set<UUID> usersReacted = new HashSet<>();

    public void addReaction(UUID userId) {
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

    public Set<UUID> getUsersReacted() {
        return usersReacted;
    }

    public void setUsersReacted(Set<UUID> usersReacted) {
        this.usersReacted = usersReacted;
    }
}
