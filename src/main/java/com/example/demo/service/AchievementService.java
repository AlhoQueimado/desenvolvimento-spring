package com.example.demo.service;

import com.example.demo.dto.AchievementDto;
import com.example.demo.dto.AchievementDto;
import com.example.demo.entity.Achievement;

import java.util.List;
import java.util.Set;

public interface AchievementService {
    AchievementDto createAchievement(AchievementDto achievementDto);

    AchievementDto getAchievementById(Long id);

    AchievementDto updateAchievement(Long id, AchievementDto achievementDto);

    void deleteAchievement(Long id);
    List<AchievementDto> getAllAchievements();


    void addAchievementToUser(Long userId, Long achievementId);
    public Set<Achievement> getAchievementByUserId(Long id);
}
