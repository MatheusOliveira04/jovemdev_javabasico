package br.com.trier.aula_05_disciplinas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Avaliacao {

	private String prova;
	private List<Double> notas = new ArrayList<>();
	private Disciplina disciplina;
	
	public boolean addNotas(Double notas) {
		getNotas().add(notas);
		return true;
	}
}
