package br.com.trier.aula_05_disciplinas;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Avaliacao {

	@NonNull
	private Aluno aluno;
	@NonNull
	private Disciplina disciplina;
	private List<Double> notas;
}
