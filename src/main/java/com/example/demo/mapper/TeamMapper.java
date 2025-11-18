package com.example.demo.mapper;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;

import java.util.HashSet;
import java.util.Set;

public class TeamMapper {
    public static TeamDto maptoDto(Team team) {
        TeamDto teamDto = new TeamDto(
                team.getId(), team.getName(), team.getUsers()
        );

        return teamDto;
    }

    public static TeamDto maptoDisplayDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        Set<User> users = new HashSet<>();

        for (User user : team.getUsers()) {
            user.setPassword(null);
            users.add(user);
        }
        teamDto.setUsers(users);
        return teamDto;
    }

    public static Team maptoEntity(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setUsers(teamDto.getUsers());

        return team;
    }
}
