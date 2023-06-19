package com.study.kafka.message;

import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.service.CarPostTrackingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostTrackingService carPostTrackingService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(CarPostDTO carPost) {
        LOG.info("ANALYTICS DATA - Received Car Post information: {} - {}", carPost.getProperties().get("uuid"), carPost);
        this.carPostTrackingService.saveCarPostTrack(carPost);
    }

}
