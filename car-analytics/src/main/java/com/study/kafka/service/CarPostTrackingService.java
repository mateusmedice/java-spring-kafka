package com.study.kafka.service;

import com.study.kafka.model.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface CarPostTrackingService {

    void saveCarPostTrack(CarPostDTO carPostDTO);
}
