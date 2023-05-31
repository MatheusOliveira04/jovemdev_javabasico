package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.models.Pessoa;

public class PessoaTest {

	private List<Pessoa> list = new ArrayList<>();
	
	@BeforeEach
	void init() {
		Pessoa p1 = new Pessoa("Pessoa", "Dor");
		list.add(p1);
	}
	
	@Test
	@DisplayName("Testa os sets da Pessoa")
	void setPessoa() {
		list.get(0).setName("Pessoa 1");
		list.get(0).setSintoma("Gripe");
		assertEquals("Pessoa 1", list.get(0).getName());
		assertEquals("Gripe", list.get(0).getSintoma());
	}
}
