package com.study.kafka.service.impl;

import com.study.kafka.model.dto.SellerDTO;
import com.study.kafka.model.entity.Seller;
import com.study.kafka.repository.SellerRepository;
import com.study.kafka.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void createSeller(SellerDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setName(sellerDTO.getName());
        seller.setType(sellerDTO.getType());
        seller.setContactNumber(sellerDTO.getContactNumber());
        this.sellerRepository.save(seller);
    }

}
