package com.kris.demo2.demo2.repo;

import com.kris.demo2.demo2.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CabRepository extends JpaRepository<Cab, UUID> {
}
