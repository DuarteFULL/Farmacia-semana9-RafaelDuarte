package br.com.semana9.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.semana9.farmacia.dto.AtualizarProdutoRecord;
import br.com.semana9.farmacia.dto.ProdutoListagemRecord;
import br.com.semana9.farmacia.dto.ProdutoRecord;
import br.com.semana9.farmacia.modelo.Fabricante;
import br.com.semana9.farmacia.modelo.Produto;
import br.com.semana9.farmacia.repository.FabricanteRepository;
import br.com.semana9.farmacia.repository.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pRepository;

	@Autowired
	private FabricanteRepository fRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid ProdutoRecord pRecord, UriComponentsBuilder uriBuilder){
		//Essa funcionalidade ainda não esta funcionando, é retornar um erro ao tentar cadastras o fabricante.
		//System.out.println("1============================");
		//System.out.println("CADASTRAR Fabricante");
		Fabricante fabricante = new Fabricante(pRecord.fabricante().nome());
		//System.out.println(fabricante.toString());
		fRepository.save(fabricante);
		Fabricante novoFab = fRepository.findByNome(fabricante.getNome());
		//System.out.println("2============================");
		//System.out.println("IMPRIME Fabricante depois de cadastrador");
		//System.out.println(novoFab.toString());

		//System.out.println("3============================");
		//System.out.println("CADASTRAR produto");
		Produto produto = new Produto(pRecord);
		produto.setFabricante(novoFab);
		//System.out.println("4============================");
		//System.out.println("IMPRIME Produto antes de cadastrador");
		//System.out.println(produto.toString());
		pRepository.save(produto);
		Produto novoPro = pRepository.findByNome(produto.getNome());
		//System.out.println("============================");
		//System.out.println("IMPRIME Produto depois de cadastrador");
		//System.out.println(novoPro.toString());

		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();



		return ResponseEntity.created(uri).body(new ProdutoAtualizadoRecord(produto));
	}

	@GetMapping
	public ResponseEntity<Page<ProdutoListagemRecord>> exibit(Pageable pagina){
		System.out.println("============================");
		System.out.println("EXIBIR NA TELA");
		var page = pRepository.findAll(pagina).map(ProdutoListagemRecord::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizarProdutoRecord pRecord){
		var produto = pRepository.getReferenceById(pRecord.id());

		produto.atualizar(pRecord);	
		
		return ResponseEntity.ok(new ProdutoAtualizadoRecord(produto));
	}	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable int id){
		pRepository.deleteById(id);
		//Se fosse uma exclusao lógica:
		//var produto = pRepository.getReferenceById(id);
		//produto.excluir();
		return ResponseEntity.noContent().build();
	}


}