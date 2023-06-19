package com.study.kafka.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class CarPostDTO {

    private String model;

    private String brand;

    private Double price;

    private String description;

    private String engineVersion;

    private String city;

    private String createdDate;

    private Long sellerId;

    private String sellerName;

    private String sellerType;

    private String contact;

    private Map<String, Object> properties = new HashMap<>();

}
