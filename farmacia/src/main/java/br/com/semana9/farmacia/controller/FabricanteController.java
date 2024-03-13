package br.com.semana9.farmacia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {

	@PostMapping
	public void cadastrar(@RequestBody String json){
		System.out.println(json);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	public Fabricante() {
	}
	
	public Fabricante(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + "]";
	}

	

}