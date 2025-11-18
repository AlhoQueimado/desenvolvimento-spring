package com.example.demo.service.impl;

import com.example.demo.dto.MatchDto;
import com.example.demo.entity.Match;
import com.example.demo.entity.Team;
import com.example.demo.mapper.MatchMapper;
import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;

    @Override
    public MatchDto createMatch(MatchDto matchDto) {
        Match match = MatchMapper.maptoEntity(matchDto);
        Match savedMatch = matchRepository.save(match);

        for (Team team: matchDto.getTeams()) {
            savedMatch.addTeam(team);
        }

        savedMatch = matchRepository.save(match);

        return MatchMapper.maptoDto(savedMatch);
    }
}
