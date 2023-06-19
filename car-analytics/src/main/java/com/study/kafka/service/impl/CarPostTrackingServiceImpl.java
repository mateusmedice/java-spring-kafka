package com.study.kafka.service.impl;

import com.study.kafka.entity.CarPostTracking;
import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.repository.CarPostTrackingRepository;
import com.study.kafka.service.CarPostTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarPostTrackingServiceImpl implements CarPostTrackingService {

    @Autowired
    private CarPostTrackingRepository carPostTrackingRepository;

    @Override
    public void saveCarPostTrack(CarPostDTO carPostDTO) {

        this.carPostTrackingRepository.save(mapCarDtoToEntity(carPostDTO));
    }

    private CarPostTracking mapCarDtoToEntity(CarPostDTO carPostDTO) {

        CarPostTracking carPostTracking = new CarPostTracking();

        carPostTracking.setModel(carPostDTO.getModel());
        carPostTracking.setBrand(carPostDTO.getBrand());
        carPostTracking.setPrice(carPostDTO.getPrice());
        carPostTracking.setCity(carPostDTO.getCity());
        carPostTracking.setDescription(carPostDTO.getDescription());
        carPostTracking.setEngineVersion(carPostDTO.getEngineVersion());
        carPostTracking.setCreatedDate(String.valueOf(new Date()));

        return carPostTracking;
    }
}
