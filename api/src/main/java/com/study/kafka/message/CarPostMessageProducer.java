package com.study.kafka.message;

import com.study.kafka.model.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.UUID;

@Component
public class CarPostMessageProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDTO carPostDTO) {
        carPostDTO.getProperties().put("uuid", UUID.randomUUID().toString());
        carPostDTO.getProperties().put("messageDateTime", Calendar.getInstance().getTime());
        this.kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }

}