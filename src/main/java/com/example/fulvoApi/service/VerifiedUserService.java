package com.example.fulvoApi.service;

import com.example.fulvoApi.entity.VerifiedUser;
import com.example.fulvoApi.repository.VerifiedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VerifiedUserService {
    private final VerifiedUserRepository userRepository;

    @Autowired
    public VerifiedUserService(VerifiedUserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Optional<VerifiedUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
