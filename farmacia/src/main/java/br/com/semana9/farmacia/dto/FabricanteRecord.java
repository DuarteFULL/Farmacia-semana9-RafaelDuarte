package br.com.semana9.farmacia.dto;

import jakarta.validation.constraints.NotBlank;

public record FabricanteRecord(
    Integer id,
    @NotBlank String nome
    ) {

    }
