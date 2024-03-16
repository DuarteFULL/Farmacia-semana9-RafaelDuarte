package br.com.semana9.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semana9.farmacia.dto.FabricanteRecord;
import br.com.semana9.farmacia.modelo.Fabricante;
import br.com.semana9.farmacia.repository.FabricanteRepository;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {

	@Autowired
	private static FabricanteRepository fRepository;

	@PostMapping
	@Transactional
	public static void cadastrar(@RequestBody FabricanteRecord fRecord){
		fRepository.save(new Fabricante(fRecord));
	}

	public static void salvar(@NotBlank String nome){
		fRepository.save(new Fabricante(nome));
	}
}