package com.example.demo.mapper;

import com.example.demo.dto.GameDto;
import com.example.demo.entity.Game;

public class GameMapper {
    public static GameDto maptoDto(Game game) {
        GameDto gameDto = new GameDto(
                game.getId(), game.getName(), game.getTeamNumber(), game.getTeamNumber()
        );

        return gameDto;
    }

    public static Game maptoEntity(GameDto gameDto) {
        Game game = new Game();
        game.setId(gameDto.getId());
        game.setName(gameDto.getName());
        game.setTeamNumber(gameDto.getTeamNumber());
        game.setTeamSize(gameDto.getTeamNumber());

        return game;
    }
}
