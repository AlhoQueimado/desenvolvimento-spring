package com.example.demo.repository;

import com.example.demo.entity.Achievement;
import com.example.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement,Long> {

}
