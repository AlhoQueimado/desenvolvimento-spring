package com.example.demo.dto;

import com.example.demo.entity.Game;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
    private Long id;
    private Date date;
    private Long game;
    private Set<Team> teams;
    private Long winner;
}
