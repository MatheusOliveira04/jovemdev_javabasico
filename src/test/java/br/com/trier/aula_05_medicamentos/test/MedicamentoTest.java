package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.Enums.EnumAdministracao;
import br.com.trier.aula_05_medicamentos.models.Medicamentos;

public class MedicamentoTest {

	@Test
	@DisplayName("Testa os sets da Medicamento")
	void setMedicamento() {
		Medicamentos m = new Medicamentos("Med", EnumAdministracao.INJETAVEL);
		m.setName("Med 3");
		m.setAdmin(EnumAdministracao.ORAL);
		assertEquals("Med 3", m.getName());
		assertEquals(EnumAdministracao.ORAL, m.getAdmin());
	}
	
	@Test
	@DisplayName("Medicamento com sets null")
	void setNullMedicamento(){
		Medicamentos m = new Medicamentos("Med", EnumAdministracao.INJETAVEL);
		m.addIndicacoes(null);
		m.addContraIndicacoes(null);
		boolean verifica = (m.getIndicacoes().get(0) == null);
		assertEquals(true, verifica);
	}
}
