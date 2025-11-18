package com.example.demo.controller;


import com.example.demo.dto.GameDto;
import com.example.demo.dto.GameDto;
import com.example.demo.service.GameService;
import com.example.demo.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {
    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto gameDto) {
        GameDto savedGame = gameService.createGame(gameDto);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable("id") Long id, @RequestBody GameDto gameDto) {
        GameDto savedGame = gameService.updateGame(id, gameDto);
        return new ResponseEntity<>(savedGame, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<GameDto>> getAllGames() {
        List<GameDto> gameDtos = gameService.getAllGames();
        return new ResponseEntity<>(gameDtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable("id") Long id) {
        GameDto game = gameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
