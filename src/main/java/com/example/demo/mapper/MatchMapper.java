package com.example.demo.mapper;

import com.example.demo.dto.MatchDto;
import com.example.demo.entity.Match;

public class MatchMapper {
    public static MatchDto maptoDto(Match match) {
        MatchDto matchDto = new MatchDto(
                match.getId(), match.getDate(), match.getGame(),  match.getTeams(), match.getWinner()
        );

        return matchDto;
    }

    public static Match maptoEntity(MatchDto matchDto) {
        Match match = new Match();
        match.setId(matchDto.getId());
        match.setDate(matchDto.getDate());
        match.setGame(matchDto.getGame());
        match.setTeams(matchDto.getTeams());
        match.setWinner(matchDto.getWinner());

        return match;
    }
}
