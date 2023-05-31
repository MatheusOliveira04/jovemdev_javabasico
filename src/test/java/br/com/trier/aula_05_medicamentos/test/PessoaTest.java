package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.models.Pessoa;

public class PessoaTest {

	@Test //classe PessoaTest
	@DisplayName("Testa os sets da Pessoa")
	void setPessoa() {
		Pessoa p = new Pessoa("Pessoa", "Resfriado");
		p.setName("Pessoa 1");
		p.setSintoma("Dor");
		assertEquals("Pessoa 1", p.getName());
		assertEquals("Dor",p.getSintoma());
		
	}
}
