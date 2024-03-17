package br.com.semana9.farmacia.controller;

import br.com.semana9.farmacia.modelo.Fabricante;
import br.com.semana9.farmacia.modelo.Produto;

public record ProdutoAtualizadoRecord (
    int id,
    String nome,
    Float preco,
    String descricao,
    Fabricante fabricante
){
    public ProdutoAtualizadoRecord(Produto produto){
        this(
            produto.getId(), 
            produto.getNome(), 
            produto.getPreco(), 
            produto.getDescricao(), 
            produto.getFabricante());
    }

}
