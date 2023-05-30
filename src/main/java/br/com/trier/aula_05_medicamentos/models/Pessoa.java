package br.com.trier.aula_05_medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Pessoa {

	@Setter
	@NonNull
	private String name;
	@Setter
	@NonNull
	private String sintoma;
	private List<String> alergias = new ArrayList<>();
	private List<Medicamentos> medicamentos = new ArrayList<>();

	public void addAlergias(String alergias) {
		getAlergias().add(alergias);
	}

	public boolean addMedicamentos(Medicamentos medicamento) {
		if(medicamento.verificaIndicacao(sintoma) == true 
				&& medicamento.verificaContraIndicacoes(alergias) != true) {
		getMedicamentos().add(medicamento);
		return true;
		}
		return false;
	}
}
