package com.example.demo.mapper;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Team;

public class TeamMapper {
    public static TeamDto maptoDto(Team team) {
        TeamDto teamDto = new TeamDto(
                team.getId(), team.getName(), team.getUsers()
        );

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
