package org.igniteKafka.project.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.igniteKafka.project.model.PostEvent;

import java.util.Properties;
import java.util.UUID;

public class PostEventProducer {
    private final KafkaProducer<UUID, PostEvent> producer;

    public PostEventProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.igniteKafka.project.kafka.PostEventSerializer");
        producer = new KafkaProducer<>(props);
    }

    public void send(PostEvent event) {
        ProducerRecord<UUID, PostEvent> record = new ProducerRecord<>("POST_EVENTS", event.getPostId(), event);
        producer.send(record);
    }
}
