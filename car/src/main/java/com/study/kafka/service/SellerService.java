package com.study.kafka.service;

import com.study.kafka.model.dto.SellerDTO;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    void createSeller(SellerDTO sellerDTO);

}
