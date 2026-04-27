package com.project.watermonitor.repository;

import com.project.watermonitor.model.WaterData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaterDataRepository extends JpaRepository<WaterData, Long> {
    // This allows .save(data) to work
    List<WaterData> findAllByOrderByTimestampAsc();
}