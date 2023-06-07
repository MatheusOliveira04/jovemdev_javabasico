package br.com.trier.aula_05_disciplinas;

import lombok.Getter;

@Getter
public class Avaliacao {

	private String prova;
	private Double nota;
	private Disciplina disciplina;
	
	public Avaliacao(String prova, Double nota, Disciplina disciplina) {
		this.prova = prova;	
		if(validaNotas(nota)) {
		this.nota = nota;
		}
		this.disciplina = disciplina;
	}
	
	private boolean validaNotas(Double nota) {
		if(nota >= 0 && nota <= 10) {
			return true;
		}
		return false;
	}
}
