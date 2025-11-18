package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer teamNumber;

    @Column(nullable = false)
    private Integer teamSize;

    @OneToMany(mappedBy="game")
    private Set<Match> matches;

    public void addMatch(Match user) {
        matches.add(user);
    }

    @OneToMany(mappedBy="game")
    private Set<Achievement> achievements;

    public void addAchievement(Achievement user) {
        achievements.add(user);
    }
}
