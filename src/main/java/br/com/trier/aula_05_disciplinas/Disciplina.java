package br.com.trier.aula_05_disciplinas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Disciplina {

	private String nome;
	private Integer cargaHoraria;
	private Professor professor;
	
}
