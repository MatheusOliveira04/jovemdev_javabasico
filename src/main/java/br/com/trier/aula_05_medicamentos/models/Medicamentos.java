package br.com.trier.aula_05_medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_05_medicamentos.Enums.EnumAdministracao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medicamentos {
	
	@Setter
	@NonNull
	private String name;
	@Setter
	@NonNull
	private EnumAdministracao admin;
	private List<String> indicacoes = new ArrayList<>();
	private List<String> contraIndicacoes = new ArrayList<>();
	
	public void addIndicacoes(String indicacoes) {
		getIndicacoes().add(indicacoes);
	}
	
	public void addContraIndicacoes(String contraIndicacoes) {
		getContraIndicacoes().add(contraIndicacoes);
	}

	@Override
	public String toString() {
		return "Medicamentos [name=" + name + ", admin=" + admin + ", indicacoes=" + indicacoes + ", contraIndicacoes="
				+ contraIndicacoes + "]";
	}
	
	
}
