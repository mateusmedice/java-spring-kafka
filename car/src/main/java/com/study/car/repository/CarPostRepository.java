package com.study.car.repository;

import com.study.car.model.entity.CarPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {

}
