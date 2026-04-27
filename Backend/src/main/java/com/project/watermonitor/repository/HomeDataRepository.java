package com.project.watermonitor.repository;

import com.project.watermonitor.model.HomeData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeDataRepository extends JpaRepository<HomeData,Long> {
    List<HomeData>findByUserId(Long userdId);
}
