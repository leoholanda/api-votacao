package br.com.desafio.tecnico.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class PautaDTO {
	
	private Long codigo;
	private String dataAbertura;
	
	@NotEmpty(message = "Campo descrição não pode ser vazio.")
	@Length(min = 5, max = 100, message = "Campo descrição deve conter no mínimo 5 e máximo 100 caracteres.")
	private String descricao; 

}
