package com.example.demo.repository;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
