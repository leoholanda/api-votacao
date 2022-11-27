package br.com.desafio.tecnico.service;

import java.io.Serializable;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafio.tecnico.dto.PautaDTO;
import br.com.desafio.tecnico.entity.Pauta;
import br.com.desafio.tecnico.repository.PautaRepository;
import br.com.desafio.tecnico.util.ConversorData;

@Service
public class PautaService implements Serializable {
	
	private static final long serialVersionUID = 7537045618778216918L;
	
	@Autowired
	private PautaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	public PautaDTO salvar(PautaDTO pautaDTO) {
		Pauta entity = modelMapper.map(pautaDTO, Pauta.class);
		
		if(!repository.findByDescricao(entity.getDescricao()).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("Já foi iniciada uma Pauta hoje com a mesma descrição", entity.getDescricao()));
		}
		Pauta pautaGravada = repository.save(entity);
		PautaDTO dto = modelMapper.map(pautaGravada, PautaDTO.class);
		
		// Converte data padrão brasileiro
		dto.setDataAbertura(ConversorData.converteLocalDateTimePadraoBrasileiro(pautaGravada.getDataAbertura()));
		
		return dto;
	}
	
	public List<Pauta> listarPautas() {
		List<Pauta> pautas = repository.findAll();
		return pautas;
	}

}
