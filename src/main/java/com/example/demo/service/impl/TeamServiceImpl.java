package com.example.demo.service.impl;

import com.example.demo.dto.TeamDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final UserRepository userRepository;
    private final UserServiceImpl userServiceImpl;
    private TeamRepository teamRepository;

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = TeamMapper.maptoEntity(teamDto);
        Team savedTeam = teamRepository.save(team);

        for (User user : teamDto.getUsers()) {
            savedTeam.addUser(user);
            user.addTeam(savedTeam);
            userRepository.save(user);
        }

        savedTeam = teamRepository.save(savedTeam);

        return TeamMapper.maptoDisplayDto(savedTeam);
    }

    @Override
    public TeamDto updateTeam(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Team not found"));
        team = TeamMapper.maptoEntity(teamDto);
        team.setId(id);
        Team savedTeam = teamRepository.save(team);

        for (User user : teamDto.getUsers()) {
            savedTeam.addUser(user);
            user.addTeam(savedTeam);
            userRepository.save(user);
        }

        savedTeam = teamRepository.save(savedTeam);

        return TeamMapper.maptoDto(savedTeam);
    }

    @Override
    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Team not found"));
        return TeamMapper.maptoDto(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Team not found"));
        teamRepository.deleteById(id);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> teamDtos = new ArrayList<>();

        for (Team team : teams) {
            teamDtos.add(TeamMapper.maptoDto(team));
        }
        return teamDtos;
    }
}
