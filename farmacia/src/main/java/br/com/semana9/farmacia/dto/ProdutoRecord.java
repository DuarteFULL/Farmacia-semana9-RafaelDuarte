package br.com.semana9.farmacia.dto;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

public record ProdutoRecord(
        Integer id,
        @NotBlank String nome,
        Float preco,
        @NotBlank String descricao,        
        FabricanteRecord fabricante){}
