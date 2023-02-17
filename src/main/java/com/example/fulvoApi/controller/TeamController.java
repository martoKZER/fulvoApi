package com.example.fulvoApi.controller;

import com.example.fulvoApi.entity.Team;
import com.example.fulvoApi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/fulvo/teams")
public class TeamController {
    @Autowired
    public TeamService teamService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Team team) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.saveTeam(team));
    }

    // Read. Return 200

    // Cuando en los métodos de lectura, actualizado y borrado llamas a algún parámetro para que hagan su
    // función, y este lo nombras distinto al nombre que tiene en el modelo, debes especificar el nombre original
    // delante de la anotación @PathVariable.
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long teamId) {
        Optional<Team> oTeam = teamService.findTeamById(teamId);
        if (!oTeam.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else return ResponseEntity.ok(oTeam);
    }

    // ReadAll
    @GetMapping
    public List<Team> readAll() {
        List<Team> teams = StreamSupport
                .stream(teamService.findAllTeams().spliterator(), false)
                .collect(Collectors.toList());
        return teams;
    }


    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Team teamDetails, @PathVariable(value = "id") Long teamId) {
        Optional<Team> team = teamService.findTeamById(teamId);
        if (!team.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // BeanUtils.copyProperties(teamDetails, team.get());
        team.get().setName(teamDetails.getName());
        team.get().setLogo(teamDetails.getLogo());
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.saveTeam(team.get()));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long teamId) {
        if (!teamService.findTeamById(teamId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        teamService.deleteTeamById(teamId);
        return ResponseEntity.ok().build();
    }
}
