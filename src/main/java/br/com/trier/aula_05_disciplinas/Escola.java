package br.com.trier.aula_05_disciplinas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Escola {

	private List<Aluno> alunos = new ArrayList<>();
	private List<Disciplina> disciplinas = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();
	
	public boolean cadastrarProfessor(Professor profes) {
		professores.add(profes);
		return true;
	}
	
	public boolean cadastrarDisciplina(Disciplina disciplina) {
		if(existeProfessor(disciplina)) {
		disciplinas.add(disciplina);
		return true;
		}
		return false;
	}
	
	public boolean cadastrarAluno(Aluno aluno) {
		if(!existeDisciplina(aluno)) {
		alunos.add(aluno);
		return true;
		}
		return false;
	}
	
	private boolean existeDisciplina(Aluno aluno) {
		return getDisciplinas().stream()
		.anyMatch(d -> d.equals(aluno.getDisciplina()));
	}
	
	private boolean existeProfessor(Disciplina disciplina) {
		return getProfessores().stream()
				.anyMatch(p -> p.equals(disciplina.getProfessor()));
	}
	
}
