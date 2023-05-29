package br.com.trier.aula_05_medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Setter
	private String name;
	@Setter
	private String sintoma;
	private List<String> alergias = new ArrayList<>();
	private List<Medicamentos> medicamentos = new ArrayList<>();
	
	public void addAlergias(String alergias) {
		getAlergias().add(alergias);
	}
	
	public void addMedicamentos(Medicamentos medicamentos) {
		getMedicamentos().add(medicamentos);
	}
}
