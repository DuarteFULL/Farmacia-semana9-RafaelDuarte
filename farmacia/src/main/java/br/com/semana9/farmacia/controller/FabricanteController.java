package br.com.semana9.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.repository.FabricanteRepository;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteRepository fRepository;

	@PostMapping
	public void cadastrar(@RequestBody String json){
		System.out.println(json);
	}
}