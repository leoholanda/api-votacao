package br.com.desafio.tecnico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.tecnico.dto.PautaDTO;
import br.com.desafio.tecnico.entity.Pauta;
import br.com.desafio.tecnico.responses.Response;
import br.com.desafio.tecnico.service.PautaService;

@RestController
@RequestMapping("/api/pauta")
public class PautaController {
	
	@Autowired
	private PautaService pautaService;
	
	@PostMapping
	public ResponseEntity<Response<PautaDTO>> cadastrarFilme(@Valid @RequestBody PautaDTO pautaDTO,
			BindingResult result) {
		Response<PautaDTO> response = new Response<PautaDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		PautaDTO pautaGravada = pautaService.salvar(pautaDTO);
		response.setData(pautaGravada);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping
    public ResponseEntity<List<Pauta>> consultarFilmes() {
    	List<Pauta> filmes = pautaService.listarPautas();
        return ResponseEntity.status(HttpStatus.OK).body(filmes);
	}

}
