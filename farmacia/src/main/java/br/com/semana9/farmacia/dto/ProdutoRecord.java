package br.com.semana9.farmacia.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProdutoRecord(
        @NotBlank String nome,
        @NotBlank @Email String descricao,
        @NotBlank Float preco,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
        @NotNull @Valid FabricanteRecord fabricante
) {
}
