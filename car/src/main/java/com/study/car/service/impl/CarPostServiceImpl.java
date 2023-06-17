package com.study.car.service.impl;

import com.study.car.message.KafkaConsumerMessage;
import com.study.car.model.dto.CarPostDTO;
import com.study.car.model.entity.CarPost;
import com.study.car.repository.CarPostRepository;
import com.study.car.repository.SellerRepository;
import com.study.car.service.CarPostService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarPostServiceImpl implements CarPostService {

    private final Logger LOG = LoggerFactory.getLogger(CarPostServiceImpl.class);

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPost carPost = this.mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPost);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarsSales.add(mapEntityToDTO(item));
        });
        return listCarsSales;

    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {

        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);

        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }


    private CarPost mapCarDtoToEntity(CarPostDTO carPostDTO) {
        CarPost carPostEntity = new CarPost();

        sellerRepository.findById(carPostDTO.getSellerId()).ifPresentOrElse(item->{
            carPostEntity.setSeller(item);
            carPostEntity.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

    private CarPostDTO mapEntityToDTO(CarPost carPost) {

        return CarPostDTO.builder()
                .brand(carPost.getBrand())
                .city(carPost.getCity())
                .model(carPost.getModel())
                .description(carPost.getDescription())
                .engineVersion(carPost.getEngineVersion())
                .createdDate(carPost.getCreatedDate())
                .sellerName(carPost.getSeller().getName())
                .price(carPost.getPrice())
                .build();
    }

}
