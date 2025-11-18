package com.example.demo.service;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.GameDto;

import java.util.List;

public interface GameService {
    GameDto createGame(GameDto gameDto);

    GameDto getGameById(Long id);

    GameDto updateGame(Long id, GameDto gameDto);

    void deleteGame(Long id);

    List<GameDto> getAllGames();
}
