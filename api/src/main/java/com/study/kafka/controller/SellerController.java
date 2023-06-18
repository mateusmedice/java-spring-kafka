package com.study.kafka.controller;


import com.study.kafka.model.dto.SellerDTO;
import com.study.kafka.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private final Logger LOG = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody SellerDTO sellerDTO) {
        LOG.info("USANDO API REST - Criando Novo Usuário: {}", sellerDTO);
        sellerService.saveSeller(sellerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
