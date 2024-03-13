package br.com.semana9.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.dto.ProdutoRecord;
import br.com.semana9.farmacia.modelo.Produto;
import br.com.semana9.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pRepository;
	
	@PostMapping
	public void cadastrar(@RequestBody ProdutoRecord pRecord){
		pRepository.save(new Produto(nuul, pRecord.getNome(), pRecord.getDescricao(), pRecord.getPreco(), pRecord.getFabricante()));
		System.out.println(json);
	}

	@GetMapping
	public void exibit(){
		System.out.println("EXIBIR NA TELA");
	}


}