package com.example.demo.service.impl;

import com.example.demo.dto.AchievementDto;
import com.example.demo.dto.AchievementDto;
import com.example.demo.entity.Achievement;
import com.example.demo.entity.Achievement;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.AchievementMapper;
import com.example.demo.mapper.AchievementMapper;
import com.example.demo.repository.AchievementRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AchievementService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public AchievementDto createAchievement(AchievementDto achievementDto) {
        Achievement achievement = AchievementMapper.maptoEntity(achievementDto);
        Achievement savedAchievement = achievementRepository.save(achievement);


        return AchievementMapper.maptoDto(savedAchievement);
    }

    @Override
    public AchievementDto updateAchievement(Long id, AchievementDto achievementDto) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new NotFoundException("Achievement not found"));
        achievement = AchievementMapper.maptoEntity(achievementDto);
        achievement.setId(id);
        Achievement savedAchievement = achievementRepository.save(achievement);

        return AchievementMapper.maptoDto(savedAchievement);
    }

    @Override
    public AchievementDto getAchievementById(Long id) {
        Achievement achievement = achievementRepository.findById(id).orElseThrow(() -> new NotFoundException("Achievement not found"));
        return AchievementMapper.maptoDto(achievement);
    }

    @Override
    public void deleteAchievement(Long id) {
        achievementRepository.findById(id).orElseThrow(() -> new NotFoundException("Achievement not found"));
        achievementRepository.deleteById(id);
    }

    @Override
    public List<AchievementDto> getAllAchievements() {
        List<Achievement> achievements = achievementRepository.findAll();
        List<AchievementDto> achievementDtos = new ArrayList<>();

        for (Achievement achievement : achievements) {
            achievementDtos.add(AchievementMapper.maptoDto(achievement));
        }
        return achievementDtos;
    }


    @Override
    public void addAchievementToUser(Long userId, Long achievementId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Achievement achievement = achievementRepository.findById(achievementId).orElseThrow(() -> new NotFoundException("Achievement not found"));
        user.addAchievement(achievement);
    }

    @Override
    public Set<Achievement> getAchievementByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return user.getAchievements();
    }
}
