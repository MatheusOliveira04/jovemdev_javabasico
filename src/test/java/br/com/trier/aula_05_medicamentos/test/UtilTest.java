package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.Enums.EnumAdministracao;
import br.com.trier.aula_05_medicamentos.models.Medicamentos;
import br.com.trier.aula_05_medicamentos.models.Pessoa;
import br.com.trier.aula_05_medicamentos.utils.Util;

public class UtilTest {

	private Util dados = new Util();
	
	@BeforeEach
	void init() {
		dados.clearListPessoa();
		dados.clearListMedicamentos();
		Pessoa p1 = new Pessoa("Pessoa 1", "Dor");
		p1.addAlergias("Diabete");
	
		Medicamentos m1 = new Medicamentos("Med 1", EnumAdministracao.ORAL);
		m1.addIndicacoes("Dor");
		
		dados.pessoa.add(p1);
		dados.medicamentos.add(m1);
	}
	
	@Test
	@DisplayName("Verifica se o preescrever está correto")
	void preescreverOk() {
		assertEquals(1, dados.listAllMedicamentos().size());
		assertEquals(1, dados.listAllMedicamentos().size());
		Pessoa p = dados.pessoa.get(0);
		Medicamentos m = dados.medicamentos.get(0);
		assertEquals(p.getName(), "Pessoa 1");
		boolean verifica = dados.fazerPrescricao(p, m);
		assertEquals(true, verifica);
		
	}
}
