package br.com.semana9.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.dto.AtualizarProdutoRecord;
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
		//Essa funcionalidade ainda não esta funcionando, é retornar um erro ao tentar cadastras o fabricante.
		System.out.println("============================");
		System.out.println("CADASTRAR PRODUTO");
		FabricanteController.salvar(pRecord.fabricante().nome());
		pRepository.save(new Produto(pRecord));
	}

	@GetMapping
	public Page<ProdutoListagemRecord> exibit(Pageable pagina){
		System.out.println("============================");
		System.out.println("EXIBIR NA TELA");
		return pRepository.findAll(pagina).map(ProdutoListagemRecord::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizarProdutoRecord pRecord){
		var produto = pRepository.getReferenceById(pRecord.id());

		produto.atualizar(pRecord);		
	}	
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable int id){
		pRepository.deleteById(id);
		//Se fosse uma exclusao lógica:
		//var produto = pRepository.getReferenceById(id);
		//produto.excluir();
	}


}