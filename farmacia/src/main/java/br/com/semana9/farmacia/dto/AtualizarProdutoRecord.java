package br.com.semana9.farmacia.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarProdutoRecord(
        @NotNull Integer id,
        String descricao,
        Float preco){}
