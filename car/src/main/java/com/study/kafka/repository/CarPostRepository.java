package com.study.kafka.repository;

import com.study.kafka.model.entity.CarPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {

}
