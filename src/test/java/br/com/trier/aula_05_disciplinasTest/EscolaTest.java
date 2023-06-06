package br.com.trier.aula_05_disciplinasTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	}
	
	@Test
	@DisplayName("Cadastra um novo professor")
	void cadastraProfOk(){
		Professor p2 = new Professor("Marcos", EnumFormacao.POS_GRADUACAO);
		escola.cadastrarProfessor(p2);
		assertEquals(2, escola.getProfessores().size());
		assertEquals("Marcos", p2.getNome());
		assertEquals(EnumFormacao.POS_GRADUACAO, p2.getFormacao());
	}
	
	
}
