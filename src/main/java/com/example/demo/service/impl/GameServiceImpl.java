package com.example.demo.service.impl;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;
import com.example.demo.mapper.GameMapper;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import com.example.demo.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;

    @Override
    public GameDto createGame(GameDto gameDto) {
        Game game = GameMapper.maptoEntity(gameDto);
        Game savedGame = gameRepository.save(game);


        return GameMapper.maptoDto(savedGame);
    }
}
