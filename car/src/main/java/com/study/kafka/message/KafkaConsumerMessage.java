package com.study.kafka.message;

import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPost) {
        LOG.info("CAR STORE - Received Car Post information: {} - {}", carPost.getProperties().get("uuid"), carPost);
        this.carPostService.newPostDetails(carPost);
    }

}
