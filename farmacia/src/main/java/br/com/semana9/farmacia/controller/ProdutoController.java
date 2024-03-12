package br.com.semana9.farmacia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.modelo.Fabricante;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@PostMapping
	public void cadastrar(@RequestBody String json){
		System.out.println(json);
	}

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private double preco;    	
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//private Fabricante fabricante;
	
	//public Produto() {
	//}
	
	// public Produto(String nome, String descricao, float preco, Fabricante fabricante) {
	// 	this.nome = nome;
	// 	this.descricao = descricao;
	// 	this.preco = preco;
	// 	this.fabricante = fabricante;
	// }

	

	

	// @Override
	// public String toString() {
	// 	return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
	// 			+ ", create_time=, fabricante=" + fabricante + "]";
	// }

	

}