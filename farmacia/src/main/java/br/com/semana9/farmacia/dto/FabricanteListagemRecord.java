package br.com.semana9.farmacia.dto;

import br.com.semana9.farmacia.modelo.Fabricante;


public record FabricanteListagemRecord (
    String nome
){

    public FabricanteListagemRecord (Fabricante fabricante){
        this(
            fabricante.getNome()
            );
    }

}
