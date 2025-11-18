package com.example.demo.controller;


import com.example.demo.dto.TeamDto;
import com.example.demo.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        TeamDto savedTeam = teamService.createTeam(teamDto);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable("id") Long id, @RequestBody TeamDto teamDto) {
        TeamDto savedTeam = teamService.updateTeam(id, teamDto);
        return new ResponseEntity<>(savedTeam, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> teamDtos = teamService.getAllTeams();
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable("id") Long id) {
        TeamDto team = teamService.getTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
