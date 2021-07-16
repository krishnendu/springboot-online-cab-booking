package com.kris.demo2.demo2.repo;

import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    List<Passenger> findAllByUserIsNotNull();

    List<Passenger> findAllByUserUserName(String userName);

    Optional<Passenger> findByUserUserName(String userName);
}
