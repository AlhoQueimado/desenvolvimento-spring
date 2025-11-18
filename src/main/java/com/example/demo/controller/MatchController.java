package com.example.demo.controller;


import com.example.demo.dto.MatchDto;
import com.example.demo.dto.MatchDto;
import com.example.demo.service.MatchService;
import com.example.demo.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/update/{id}")
    public ResponseEntity<MatchDto> updateMatch(@PathVariable("id") Long id, @RequestBody MatchDto matchDto) {
        MatchDto savedMatch = matchService.updateMatch(id, matchDto);
        return new ResponseEntity<>(savedMatch, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<MatchDto>> getAllMatchs() {
        List<MatchDto> matchDtos = matchService.getAllMatches();
        return new ResponseEntity<>(matchDtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable("id") Long id) {
        MatchDto match = matchService.getMatchById(id);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }
}
