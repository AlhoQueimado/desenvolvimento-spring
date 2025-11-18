package com.example.demo.mapper;

import com.example.demo.dto.AchievementDto;
import com.example.demo.entity.Achievement;

public class AchievementMapper {
    public static AchievementDto maptoDto(Achievement achievement) {
        AchievementDto achievementDto = new AchievementDto(
                achievement.getId(), achievement.getName(), achievement.getDescription(), achievement.getGame()
        );

        return achievementDto;
    }

    public static Achievement maptoEntity(AchievementDto achievementDto) {
        Achievement achievement = new Achievement();
        achievement.setId(achievementDto.getId());
        achievement.setName(achievementDto.getName());
        achievement.setDescription(achievementDto.getDescription());
        achievement.setGame(achievementDto.getGame());

        return achievement;
    }
}
