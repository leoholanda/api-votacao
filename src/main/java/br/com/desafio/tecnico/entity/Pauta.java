package br.com.desafio.tecnico.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pauta implements Serializable {

	private static final long serialVersionUID = 3442374526234097513L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "data_abertura")
	private LocalDateTime dataAbertura;
	
	@Column(name = "pauta_descricao")
	private String descricao;

	
	@PrePersist
	public void create() {
		dataAbertura = LocalDateTime.now();
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}
	
	
}
