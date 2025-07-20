package org.igniteKafka.project.kafka;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.igniteKafka.project.enums.ReactionType;
import org.igniteKafka.project.model.PostEvent;
import org.igniteKafka.project.model.PostStats;

import java.util.Map;
import java.util.Properties;

public class PostEventProducer {
    private final KafkaProducer<String, PostEvent> producer;

    public PostEventProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "com.socialmedia.kafka.serialization.PostEventSerializer");
        producer = new KafkaProducer<>(props);
    }

    public void send(PostEvent event) {
        ProducerRecord<String, PostEvent> record = new ProducerRecord<>("POST_EVENTS", event.getPostId(), event);
        producer.send(record);
    }
}
