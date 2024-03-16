package br.com.semana9.farmacia.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecord(
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotBlank Float preco,
        @NotNull @Valid FabricanteRecord fabricante
        ){
                
        }
