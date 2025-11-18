package com.example.demo.controller;


import com.example.demo.dto.GameDto;
import com.example.demo.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
