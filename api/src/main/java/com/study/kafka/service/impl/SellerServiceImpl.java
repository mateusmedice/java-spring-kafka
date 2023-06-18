package com.study.kafka.service.impl;

import com.study.kafka.client.CarPostServiceClient;
import com.study.kafka.model.dto.SellerDTO;
import com.study.kafka.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private CarPostServiceClient carPostServiceClient;

    @Override
    public void saveSeller(SellerDTO sellerDTO) {

        this.carPostServiceClient.postSellerClient(sellerDTO);
    }
}
