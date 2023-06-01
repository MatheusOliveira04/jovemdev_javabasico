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
}
