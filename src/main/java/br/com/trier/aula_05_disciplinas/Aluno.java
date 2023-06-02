package br.com.trier.aula_05_disciplinas;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	private List<Disciplina> disciplina;                       
	private List<Avaliacao> avaliacao;
	
	private boolean existDisciplina(Disciplina disciplina) {
		return this.disciplina.stream()
		.anyMatch(d -> d.equals(disciplina));
	}
	
	/*public List<Double> notasDisciplina(Disciplina disciplina){
		if(existDisciplina(disciplina)) {
			
		}
	}*/
}
