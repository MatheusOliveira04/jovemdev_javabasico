package br.com.trier.aula_05_disciplinasTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_disciplinas.Aluno;
import br.com.trier.aula_05_disciplinas.Avaliacao;
import br.com.trier.aula_05_disciplinas.Disciplina;
import br.com.trier.aula_05_disciplinas.EnumFormacao;
import br.com.trier.aula_05_disciplinas.Escola;
import br.com.trier.aula_05_disciplinas.Professor;

public class EscolaTest {

	private Escola escola = new Escola();
	
	@BeforeEach
	void init() {	
		
		Professor p1 = new Professor("Luiz", EnumFormacao.GRADUACAO);
		escola.cadastrarProfessor(p1);
		
		Disciplina d1 = new Disciplina("Matemática",15, p1);
		escola.cadastrarDisciplina(d1);
		
		Aluno a1 = new Aluno("Matheus");
		a1.addDisciplina(d1);
		a1.addAvaliacao(new Avaliacao("Prova 1", 9.0, d1));
		escola.cadastrarAluno(a1);
	}
	
	@Test
	@DisplayName("teste cadastra professor válida")
	void cadastraProfOk(){
		Professor p2 = escola.getProfessores().get(0);
		assertEquals(1, escola.getProfessores().size());
		assertEquals("Luiz", p2.getNome());
		assertEquals(EnumFormacao.GRADUACAO, p2.getFormacao());
	}
	
	@Test
	@DisplayName("teste cadastra disciplina válida")
	void cadastraDiscOk() {
		Professor p2 = escola.getProfessores().get(0);
		Disciplina d2 = escola.getDisciplinas().get(0);
		assertEquals("Matemática", d2.getNome());
		assertEquals(15, d2.getCargaHoraria());
		assertEquals(p2, d2.getProfessor());
		assertEquals(1, escola.getDisciplinas().size());
	}
	
	@Test
	@DisplayName("teste cadastra disciplina que não existe professor, disciplina não cadastra")
	void cadastraDiscSemProf() {
		Professor p2 = new Professor("Marcos", EnumFormacao.ESPECIALIZACAO);
		Disciplina d2 = new Disciplina("Português", 15, p2);
		boolean verifica = escola.cadastrarDisciplina(d2);
		assertEquals(false, verifica);
		assertEquals(1, escola.getDisciplinas().size());
		assertEquals(1, escola.getProfessores().size());
		}
	
	@Test
	@DisplayName("teste cadastra aluno válido")
	void cadastraAlunoOk() {
		Disciplina d2 = escola.getDisciplinas().get(0);
		assertEquals(1, escola.getDisciplinas().size());
		Aluno a = escola.getAlunos().get(0);
		assertEquals(1, escola.getAlunos().size());
		assertEquals("Matheus", a.getNome());
		assertEquals(9.0, a.getAvaliacao().get(0).getNota());
		assertEquals("Prova 1", a.getAvaliacao().get(0).getProva());
		assertEquals(d2, a.getAvaliacao().get(0).getDisciplina()); 
		assertEquals("Matemática", d2.getNome());
		assertEquals(15, d2.getCargaHoraria());
		assertEquals(1, escola.getDisciplinas().size());
	}
	
	@Test
	@DisplayName("teste disciplina da avaliação, aluno não está matriculado na disciplina da prova")
	void cadastraAlunoProvNot() {
		Professor p2 = escola.getProfessores().get(0);
		Disciplina d2 = escola.getDisciplinas().get(0);
		Aluno a2 = new Aluno("Marcos");
		a2.addDisciplina(d2);
		Disciplina d3 = new Disciplina("Geografia", 15, p2);
		a2.addAvaliacao(new Avaliacao("Prova 2", 5.0, d3));
		boolean ver = escola.cadastrarAluno(a2);
	}
}
