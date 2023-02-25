package com.example.fulvoApi.repository;

import com.example.fulvoApi.entity.VerifiedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifiedUserRepository extends JpaRepository<VerifiedUser, Long> {
    Optional<VerifiedUser> findByEmail(String email);
}
