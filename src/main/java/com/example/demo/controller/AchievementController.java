package com.example.demo.controller;


import com.example.demo.dto.AchievementDto;
import com.example.demo.dto.AchievementDto;
import com.example.demo.entity.Achievement;
import com.example.demo.service.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/achievement")
public class AchievementController {
    private AchievementService achievementService;

    @PostMapping
    public ResponseEntity<AchievementDto> createAchievement(@RequestBody AchievementDto achievementDto) {
        AchievementDto savedAchievement = achievementService.createAchievement(achievementDto);
        return new ResponseEntity<>(savedAchievement, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<AchievementDto> updateAchievement(@PathVariable("id") Long id, @RequestBody AchievementDto achievementDto) {
        AchievementDto savedAchievement = achievementService.updateAchievement(id, achievementDto);
        return new ResponseEntity<>(savedAchievement, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAchievement(@PathVariable("id") Long id) {
        achievementService.deleteAchievement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<AchievementDto>> getAllAchievements() {
        List<AchievementDto> achievementDtos = achievementService.getAllAchievements();
        return new ResponseEntity<>(achievementDtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AchievementDto> getAchievementById(@PathVariable("id") Long id) {
        AchievementDto achievement = achievementService.getAchievementById(id);
        return new ResponseEntity<>(achievement, HttpStatus.OK);
    }

    @PostMapping("/grant/{id}/{achievement_id}")
    public ResponseEntity<HttpStatus> deleteAchievement(@PathVariable("id") Long id,  @PathVariable("achievement_id") Long achievementId) {
        achievementService.addAchievementToUser(id, achievementId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity<Set<Achievement>> getAchievementByUser(@PathVariable("id") Long id) {
        Set<Achievement> achievement = achievementService.getAchievementByUserId(id);
        return new ResponseEntity<>(achievement, HttpStatus.OK);
    }
}
