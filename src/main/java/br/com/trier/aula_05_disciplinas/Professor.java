package br.com.trier.aula_05_disciplinas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Professor {

	private String nome;
	private EnumFormacao formacao;
}
