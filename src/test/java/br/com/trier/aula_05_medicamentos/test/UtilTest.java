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
		Pessoa p2 = new Pessoa("Pessoa 2", "Gripe");
		p2.addAlergias("Dengue");
		
		dados.cadastrarPessoas(p1);
		dados.cadastrarPessoas(p2);
		
		Medicamentos m1 = new Medicamentos("Med 1", EnumAdministracao.ORAL);
		m1.addIndicacoes("Dor");
		m1.addContraIndicacoes("Cancêr");
		Medicamentos m2 = new Medicamentos("Med 2", EnumAdministracao.SUPOSITORIO);
		m2.addIndicacoes("Gripe");
		m2.addContraIndicacoes("Dengue");
		
		dados.cadastrarMedicamentos(m1);
		dados.cadastrarMedicamentos(m2);
		
	}
	
	@Test
	@DisplayName("medicamento está cadastrado")
	void existeMedicamento() {
		Medicamentos m1 = dados.getMedicamentos().get(0);
		assertEquals(m1.getName(), "Med 1");
		assertEquals(m1.getAdmin(), EnumAdministracao.ORAL);
		assertEquals(m1.getIndicacoes().get(0),"Dor");
		assertEquals(1, m1.getIndicacoes().size());
		Medicamentos m2 = dados.getMedicamentos().get(1);
		assertEquals("Med 2", m2.getName());
		assertEquals(m2.getAdmin(),EnumAdministracao.SUPOSITORIO);
		assertEquals(true, m2.getIndicacoes().contains("Gripe"));
		assertEquals(true, m2.getContraIndicacoes().contains("Dengue"));
	}
	
	@Test
	@DisplayName("pessoa está cadastrada")
	void existePessoa() {
		Pessoa p1 = dados.getPessoa().get(0);
		assertEquals("Pessoa 1", p1.getName());
		assertEquals("Dor", p1.getSintoma());
		assertEquals(true, p1.getAlergias().contains("Diabete"));
		Pessoa p2 = dados.getPessoa().get(1);
		assertEquals("Pessoa 2", p2.getName());
		assertEquals("Gripe", p2.getSintoma());
		assertEquals(true, p2.getAlergias().contains("Dengue"));
	}
	
	@Test
	@DisplayName("preescrever está correto")
	void prescreverOk() {
		Pessoa p = dados.getPessoa().get(0);
		Medicamentos m = dados.getMedicamentos().get(0);
		assertEquals(p.getName(), "Pessoa 1");
		boolean verifica = dados.fazerPrescricao(p, m);
		assertEquals(true, verifica);
		assertEquals(1, p.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("sintoma diferente da indicação")
	void erroPrescreverIndicacao() {
		Pessoa p = dados.getPessoa().get(1);
		Medicamentos m = dados.getMedicamentos().get(0);
		assertEquals("Med 1", m.getName());
		assertEquals(true, m.getIndicacoes().contains("Dor"));
		boolean verifica = dados.fazerPrescricao(p, m);
		assertEquals(false, verifica);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("contra indicado para a alergia especificado")
	void erroPrescreverContraIndicado() {
		Pessoa p = dados.getPessoa().get(1);
		Medicamentos m = dados.getMedicamentos().get(1);
		boolean verifica = dados.fazerPrescricao(p, m);	
		assertEquals(false, dados.fazerPrescricao(p, m));
		assertEquals(0, p.getMedicamentos().size());
	}
		
	@Test
	@DisplayName("Mostra que o tamanho da list medicamento contém 2 medicamentos")
	void listPessoas() {
		List<Medicamentos> med = dados.listAllMedicamentos();
		assertEquals(2, med.size());
		assertEquals("Med 1", med.get(0).getName());
		assertEquals("Med 2", med.get(1).getName());
	}
	

	
}
