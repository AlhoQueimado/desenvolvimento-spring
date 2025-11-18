package com.example.demo.controller;


import com.example.demo.dto.MatchDto;
import com.example.demo.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/match")
public class MatchController {
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto matchDto) {
        MatchDto savedMatch = matchService.createMatch(matchDto);
        return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
    }
}
