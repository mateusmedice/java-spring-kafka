package com.study.api.service.impl;

import com.study.api.client.CarPostServiceClient;
import com.study.api.model.dto.SellerDTO;
import com.study.api.service.SellerService;
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
