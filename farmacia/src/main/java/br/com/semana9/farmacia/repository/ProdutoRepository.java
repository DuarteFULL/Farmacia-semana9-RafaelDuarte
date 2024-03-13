package br.com.semana9.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.semana9.farmacia.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
