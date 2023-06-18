package com.study.kafka.client;

import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.model.dto.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostServiceClient {

    private final String SELLERS_SERVICE_URI = "http://localhost:8081/service/sellers";
    private final String CARS_POST_SERVICE_URI = "http://localhost:8081/service/cars-post";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> getCarsForSaleClient() {
        ResponseEntity<CarPostDTO[]> responseEntity =
                this.restTemplate.getForEntity(CARS_POST_SERVICE_URI, CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void postSellerClient(SellerDTO sellerDTO) {
        this.restTemplate.postForEntity(SELLERS_SERVICE_URI, sellerDTO, SellerDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
        this.restTemplate.put(CARS_POST_SERVICE_URI + "/" + id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSaleClient(String id) {
        this.restTemplate.delete(CARS_POST_SERVICE_URI + "/" + id);
    }

}
