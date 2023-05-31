package br.com.trier.aula_05_medicamentos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_05_medicamentos.Enums.EnumAdministracao;
import br.com.trier.aula_05_medicamentos.models.Medicamentos;

public class MedicamentoTest {

	private List<Medicamentos> list = new ArrayList<>();
	
	@BeforeEach
	void init() {
		Medicamentos m1 = new Medicamentos("Med", EnumAdministracao.INJETAVEL);
		list.add(m1);
	}
	
	@Test
	@DisplayName("Testa os sets da Medicamento")
	void setMedicamento() {
		list.get(0).setName("Med 1");
		list.get(0).setAdmin(EnumAdministracao.ORAL);
		assertEquals("Med 1", list.get(0).getName());
		assertEquals(EnumAdministracao.ORAL, list.get(0).getAdmin());
	}
}
