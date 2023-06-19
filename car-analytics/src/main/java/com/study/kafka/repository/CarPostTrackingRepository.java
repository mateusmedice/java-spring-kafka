package com.study.kafka.repository;

import com.study.kafka.entity.CarPostTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostTrackingRepository extends JpaRepository<CarPostTracking, Long> {

}
