package br.com.trier.aula_05_medicamentos.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_05_medicamentos.models.Medicamentos;
import br.com.trier.aula_05_medicamentos.models.Pessoa;

public class util {

	private List<Pessoa> pessoa = new ArrayList<>();
	private List<Medicamentos> medicamentos = new ArrayList<>();

	public Medicamentos cadastrarMedicamentos(Medicamentos m) {
		medicamentos.add(m);
		return m;
	}

	public Pessoa cadastrarPessoas(Pessoa p) {
		pessoa.add(p);
		return p;
	}

	public boolean verificaMedicamentoCadastrado(Medicamentos medicamento) {
		medicamentos.stream()
		.filter(m -> m.getName().equals(medicamento))
		.findFirst()
		.orElse(null);
		if (medicamento != null) {
			return true;
		}
		return false;
	}
}
