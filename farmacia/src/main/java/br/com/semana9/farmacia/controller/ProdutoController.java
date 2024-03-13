package br.com.semana9.farmacia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@PostMapping
	public void cadastrar(@RequestBody String json){
		System.out.println(json);
	}

	@GetMapping
	public void exibit(){
		System.out.println("EXIBIR NA TELA");
	}


}