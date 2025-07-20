package org.igniteKafka.project.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.igniteKafka.project.model.PostEvent;

import java.util.Map;

public class PostEventSerializer implements Serializer<PostEvent> {
    @Override
    public byte[] serialize(String topic, PostEvent data) {
        try {
            return new ObjectMapper().writeValueAsBytes(data);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public void close() {}
}
