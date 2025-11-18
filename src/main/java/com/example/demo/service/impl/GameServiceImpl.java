package com.example.demo.service.impl;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;
import com.example.demo.entity.Match;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.GameMapper;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    @Override
    public GameDto createGame(GameDto gameDto) {
        Game game = GameMapper.maptoEntity(gameDto);
        Game savedGame = gameRepository.save(game);
        return GameMapper.maptoDto(savedGame);
    }

    @Override
    public GameDto updateGame(Long id, GameDto gameDto) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Game not found"));
        game = GameMapper.maptoEntity(gameDto);
        game.setId(id);
        Game savedGame = gameRepository.save(game);

        return GameMapper.maptoDto(savedGame);
    }

    @Override
    public GameDto getGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Game not found"));
        return GameMapper.maptoDto(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Game not found"));
        gameRepository.deleteById(id);
    }

    @Override
    public List<GameDto> getAllGames() {
        List<Game> games = gameRepository.findAll();
        List<GameDto> gameDtos = new ArrayList<>();

        for (Game game : games) {
            gameDtos.add(GameMapper.maptoDto(game));
        }
        return gameDtos;
    }
}
