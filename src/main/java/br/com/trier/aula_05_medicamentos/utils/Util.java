package br.com.trier.aula_05_medicamentos.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_05_medicamentos.models.Medicamentos;
import br.com.trier.aula_05_medicamentos.models.Pessoa;

public class Util {

	public List<Pessoa> pessoa = new ArrayList<Pessoa>();
	public List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();

	public void cadastrarMedicamentos(Medicamentos m) {
		medicamentos.add(m);
	}

	public void cadastrarPessoas(Pessoa p) {
		pessoa.add(p);
	}

	public boolean existePessoa(Pessoa p) {
		return pessoa.contains(p);
	}

	public boolean existeMedicamento(Medicamentos medicamento) {
		return this.medicamentos.contains(medicamento);
	}

	public boolean fazerPrescricao(Pessoa pessoa, Medicamentos medicamento) {
		if (existeMedicamento(medicamento) == true && existePessoa(pessoa) == true) {
			pessoa.addMedicamentos(medicamento);
			return true;
		} 
			return false;	
	}

	public List<Pessoa> listAllPessoa() {
		return pessoa;
	}

	public List<Medicamentos> listAllMedicamentos() {
		return medicamentos;
	}

	public void clearListPessoa() {
		pessoa.clear();
	}

	public void clearListMedicamentos() {
		medicamentos.clear();
	}
}
