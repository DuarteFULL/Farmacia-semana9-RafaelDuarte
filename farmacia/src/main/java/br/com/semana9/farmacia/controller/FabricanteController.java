package br.com.semana9.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.semana9.farmacia.dto.FabricanteListagemRecord;
import br.com.semana9.farmacia.dto.FabricanteRecord;
import br.com.semana9.farmacia.dto.ProdutoListagemRecord;
import br.com.semana9.farmacia.modelo.Fabricante;
import br.com.semana9.farmacia.repository.FabricanteRepository;
import br.com.semana9.farmacia.repository.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteRepository fRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid FabricanteRecord fRecord){
		Fabricante novoFabricante = new Fabricante(fRecord);
		fRepository.save(novoFabricante);

		//var uri = uriBuilder.path("/fabricantes/{id}").buildAndExpand(fabricante.getId()).toUri();
		//return ResponseEntity.created(uri).body(new FabricanteAtualizadoRecord(novoFabricante));
	}

	//@PostMapping
	@Transactional
	public void salvar(@NotBlank String nome){
		System.out.println("2=============================");
		System.out.println(nome);
		Fabricante fSalvar = new Fabricante(nome);
		System.out.println("3=============================");
		System.out.println(fSalvar.getNome());
		fRepository.save(fSalvar);
	}

	@GetMapping
	public List<FabricanteListagemRecord> exibit(){
		System.out.println("============================");
		System.out.println("EXIBIR NA TELA");
		return fRepository.findAll().stream().map(FabricanteListagemRecord::new).toList();
	}
}