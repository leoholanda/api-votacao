package br.com.desafio.tecnico.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorData {
	
	public static final String converteLocalDateTimePadraoBrasileiro(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return data.format(formatter);
	}

}
