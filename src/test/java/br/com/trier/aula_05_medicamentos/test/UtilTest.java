package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.Enums.EnumAdministracao;
import br.com.trier.aula_05_medicamentos.models.Medicamentos;
import br.com.trier.aula_05_medicamentos.models.Pessoa;
import br.com.trier.aula_05_medicamentos.utils.*;

public class UtilTest {

	private Util dados = new Util();
	
	@BeforeEach
	void init() {
		dados.limparListaPessoa();
		dados.limparListaMedicamentos();
		Medicamentos m = new Medicamentos("neosoro",EnumAdministracao.SUPOSITORIO);
		m.addIndicacoes("congestão nasal");
		m.addContraIndicacoes("alergia 1");
		dados.cadastrarMedicamentos(m);
		Pessoa p = new Pessoa("Matheus","congestão nasal");
		p.addAlergias("alergia 1");
		Pessoa p2 = new Pessoa("Luidi","congestão nasal");
		p.addAlergias("alergia 2");
		dados.cadastrarPessoas(p);
		dados.cadastrarPessoas(p2);
	}
	
	@Test
	@DisplayName("Verifica se o medimento foi cadastrado")
	public void verMedicamentoCadastrado() {
		List<Medicamentos> medic = dados.listAllMedicamentos();
		assertEquals(1, dados.listAllMedicamentos().size());
	}
}
