package com.study.kafka.controller;

import com.study.kafka.model.dto.CarPostDTO;
import com.study.kafka.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars-post")
public class CarPostController {

    private final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

    @Autowired
    private CarPostService carPostService;

    @PostMapping()
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        LOG.debug("postCarForSale(): {}", carPostDTO);
        this.carPostService.createCarPost(carPostDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        LOG.debug("getCarSales()");
        List<CarPostDTO> carsPostList = this.carPostService.getCarPostForSales();
        LOG.debug("getCarSales(): {}", carsPostList);
        return ResponseEntity.status(HttpStatus.FOUND).body(carsPostList);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@PathVariable("id") String id,
                                        @RequestBody CarPostDTO carPostDTO) {
        LOG.debug("changeCarSale(): {} - {}", id, carPostDTO);
        this.carPostService.changeCarPostForSale(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        LOG.debug("deleteCarForSale(): {}", id);
        this.carPostService.removeCarPostForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
