package com.study.api.service;

import com.study.api.model.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void createCarPost(CarPostDTO carPostDTO);

    List<CarPostDTO> getCarPostForSales();

    void changeCarPostForSale(CarPostDTO carPost, String id);

    void removeCarPostForSale(String id);


}
