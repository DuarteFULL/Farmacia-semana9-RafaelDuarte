package br.com.semana9.farmacia.dto;

import br.com.semana9.farmacia.modelo.Fabricante;
import br.com.semana9.farmacia.modelo.Produto;

public record ProdutoListagemRecord (
    Integer id,
    String nome,
    Float preco,
    String descricao,
    Fabricante fabricante
) {

    public ProdutoListagemRecord (Produto produto){
        this(
            produto.getId(),
            produto.getNome(), 
            produto.getPreco(), 
            produto.getDescricao(), 
            produto.getFabricante()
            );
    }

}
