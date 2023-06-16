package com.study.api.service;

import com.study.api.model.dto.SellerDTO;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    void saveSeller(SellerDTO sellerDTO);

}
