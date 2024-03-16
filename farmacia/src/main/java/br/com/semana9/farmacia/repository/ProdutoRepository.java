package br.com.semana9.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.semana9.farmacia.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
