package br.com.semana9.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.dto.ProdutoListagemRecord;
import br.com.semana9.farmacia.dto.ProdutoRecord;
import br.com.semana9.farmacia.modelo.Produto;
import br.com.semana9.farmacia.repository.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid ProdutoRecord pRecord){
		System.out.println(pRecord.fabricante().nome());
		FabricanteController.salvar(pRecord.fabricante().nome());
		pRepository.save(new Produto(pRecord));
	}

	@GetMapping
	public List<ProdutoListagemRecord> exibit(){
		System.out.println("============================");
		System.out.println("EXIBIR NA TELA");
		return pRepository.findAll().stream().map(ProdutoListagemRecord::new).toList();
	}


}