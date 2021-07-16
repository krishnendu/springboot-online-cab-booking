package com.kris.demo2.demo2.repo;

import com.kris.demo2.demo2.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUserName(String userName);

    void deleteByUserName(String userName);

    List<AuthUser> findAllByDriverIsNotNull();

    List<AuthUser> findAllByDriverIsNotNullAndDriverCabActiveIsFalse();
}