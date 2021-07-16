package com.kris.demo2.demo2.repo;

import com.kris.demo2.demo2.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByUserUserName(String userName);
    List<Driver> findAllByUserIsNotNull();
}
