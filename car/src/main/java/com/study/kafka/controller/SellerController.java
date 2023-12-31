package com.study.kafka.controller;

import com.study.kafka.model.dto.SellerDTO;
import com.study.kafka.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity createOwner(@RequestBody SellerDTO sellerDTO) {
        sellerService.createSeller(sellerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
