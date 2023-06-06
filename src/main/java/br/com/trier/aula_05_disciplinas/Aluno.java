package br.com.trier.aula_05_disciplinas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	private List<Disciplina> disciplina = new ArrayList<>();                       
	private List<Avaliacao> avaliacao = new ArrayList<>(); //3
	
	
	public boolean addDisciplina(Disciplina disciplina) {
		getDisciplina().add(disciplina);
		return true;
	}
	
	public boolean addAvaliacao(Avaliacao avaliacao) {
		if(existeDisciplina(avaliacao) && quantidadeProvasDisciplina(avaliacao)) {
		getAvaliacao().add(avaliacao);
		return true;
		}
		return false;
	}
	
	private boolean existeDisciplina(Avaliacao avaliacao) {
		return getDisciplina().stream()
				.anyMatch(d -> d.equals(avaliacao.getDisciplina()));
	}
	
	private boolean quantidadeProvasDisciplina(Avaliacao avaliacao) {
		int soma = 0;
		for (Avaliacao a : getAvaliacao()) {
			if(a.getDisciplina().equals(avaliacao.getDisciplina())) {
				soma++;
			}
		}
		if(soma == 3) {
			return false;
		}
		return true;
	}
}
