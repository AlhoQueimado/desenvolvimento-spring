package com.example.demo.service;

import com.example.demo.dto.MatchDto;
import com.example.demo.dto.MatchDto;

import java.util.List;

public interface MatchService {
    MatchDto createMatch(MatchDto matchDto);

    MatchDto getMatchById(Long id);

    MatchDto updateMatch(Long id, MatchDto matchDto);

    void deleteMatch(Long id);

    List<MatchDto> getAllMatches();
}
