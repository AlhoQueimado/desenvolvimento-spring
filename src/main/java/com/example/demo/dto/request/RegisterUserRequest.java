package com.example.demo.dto.request;


import com.example.demo.entity.Role;
import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatório") String name,
                                  @NotEmpty(message = "E-mail é obrigatório") String email,
                                  @NotEmpty(message = "Senha é obrigatória") String password,
                                  Role role) {
}