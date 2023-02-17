package com.example.fulvoApi.service;

import com.example.fulvoApi.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
public interface TeamService {
    public Iterable<Team> findAllTeams();
    public Page<Team> findAllTeams(Pageable pageable);
    public Optional<Team> findTeamById(Long id);
    public Team saveTeam(Team user);
    public void deleteTeamById(Long id);
}
