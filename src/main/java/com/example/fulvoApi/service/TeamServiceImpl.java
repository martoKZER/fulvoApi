package com.example.fulvoApi.service;

import com.example.fulvoApi.entity.Team;
import com.example.fulvoApi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository userRepository;

    //Puede que este método me falle, si es así, cambiar Iterable por List.
    @Override
    public Iterable<Team> findAllTeams() {
        return userRepository.findAll();
    }

    @Override
    public Page<Team> findAllTeams(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<Team> findTeamById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Team saveTeam(Team user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteTeamById(Long id) {
        userRepository.deleteById(id);
    }

}