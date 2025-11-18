package com.example.demo.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email é obrigatório") String name,
                           @NotEmpty(message = "Senha é obrigatória") String password) {
}