package com.project.watermonitor.repository;

import com.project.watermonitor.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


    Optional<UserData> findByUsername(String username);
}
