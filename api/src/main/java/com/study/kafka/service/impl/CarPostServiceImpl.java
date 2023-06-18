package com.study.kafka.service.impl;

import com.study.kafka.client.CarPostServiceClient;
import com.study.kafka.message.CarPostMessageProducer;
import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostServiceImpl implements CarPostService {

    private final Logger LOG = LoggerFactory.getLogger(CarPostServiceImpl.class);

    @Autowired
    private CarPostServiceClient carPostServiceClient;

    @Autowired
    private CarPostMessageProducer carPostMessageProducer;

    @Override
    public void createCarPost(CarPostDTO carPostDTO) {
        LOG.debug("createCar {}", carPostDTO);
        this.carPostMessageProducer.sendMessage(carPostDTO);
    }

    @Override
    public List<CarPostDTO> getCarPostForSales() {
        LOG.debug("getCarForSales {}");
        return this.carPostServiceClient.getCarsForSaleClient();
    }

    @Override
    public void changeCarPostForSale(CarPostDTO carPost, String id) {
        LOG.debug("getCarForSales {} - {}", carPost, id);
        this.carPostServiceClient.changeCarForSaleClient(carPost, id);
    }

    @Override
    public void removeCarPostForSale(String id) {
        LOG.debug("removeCarForSale {}", id);
        this.carPostServiceClient.deleteCarForSaleClient(id);
    }

}
