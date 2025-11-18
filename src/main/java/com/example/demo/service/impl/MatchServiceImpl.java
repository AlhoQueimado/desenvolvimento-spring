package com.example.demo.service.impl;

import com.example.demo.dto.MatchDto;
import com.example.demo.entity.Match;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.MatchMapper;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    @Override
    public MatchDto createMatch(MatchDto matchDto) {
        Match match = MatchMapper.maptoEntity(matchDto);
        Match savedMatch = matchRepository.save(match);

        for (Team team : matchDto.getTeams()) {
            savedMatch.addTeam(team);
            team.addMatch(savedMatch);
            teamRepository.save(team);
        }

        savedMatch = matchRepository.save(match);

        return MatchMapper.maptoDto(savedMatch);
    }

    @Override
    public MatchDto updateMatch(Long id, MatchDto matchDto) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new NotFoundException("Match not found"));
        match = MatchMapper.maptoEntity(matchDto);
        match.setId(id);
        Match savedMatch = matchRepository.save(match);

        for (Team team : matchDto.getTeams()) {
            savedMatch.addTeam(team);
            team.addMatch(savedMatch);
            teamRepository.save(team);
        }

        savedMatch = matchRepository.save(match);
        return MatchMapper.maptoDto(savedMatch);
    }

    @Override
    public MatchDto getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new NotFoundException("Match not found"));
        return MatchMapper.maptoDto(match);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.findById(id).orElseThrow(() -> new NotFoundException("Match not found"));
        matchRepository.deleteById(id);
    }

    @Override
    public List<MatchDto> getAllMatches() {
        List<Match> matchs = matchRepository.findAll();
        List<MatchDto> matchDtos = new ArrayList<>();

        for (Match match : matchs) {
            matchDtos.add(MatchMapper.maptoDto(match));
        }
        return matchDtos;
    }

}
