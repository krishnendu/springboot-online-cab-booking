package com.kris.demo2.demo2.repo;

import com.kris.demo2.demo2.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JourneyRepository extends JpaRepository<Journey, UUID> {
}
