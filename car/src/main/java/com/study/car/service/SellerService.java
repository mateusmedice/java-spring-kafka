package com.study.car.service;

import com.study.car.model.dto.SellerDTO;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    void createSeller(SellerDTO sellerDTO);

}
