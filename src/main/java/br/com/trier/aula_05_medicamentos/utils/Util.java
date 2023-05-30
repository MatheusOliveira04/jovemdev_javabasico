package br.com.trier.aula_05_medicamentos.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_05_medicamentos.models.Medicamentos;
import br.com.trier.aula_05_medicamentos.models.Pessoa;

public class Util {

	private List<Pessoa> pessoa = new ArrayList<Pessoa>();
	private List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();

	public Medicamentos cadastrarMedicamentos(Medicamentos m) {
		medicamentos.add(m);
		return m;
	}

	public Pessoa cadastrarPessoas(Pessoa p) {
		pessoa.add(p);
		return p;
	}

	public Pessoa selecionaPessoaPreviamentoCadastrada() {
		return pessoa.get(pessoa.size());
	}

	public boolean verificaMedicamentoCadastrado(Medicamentos medicamento) {
		Medicamentos med = medicamentos.stream().filter(m -> m.getName().equals(medicamento)).findFirst().orElse(null);
		if (med != null) {
			return true;
		}
		return false;
	}

	public boolean verificaSintomaEParteDoMedicamento() {
		Pessoa pes = selecionaPessoaPreviamentoCadastrada();
		Medicamentos med = medicamentos.stream().filter(m -> m.getIndicacoes().equals(pes.getSintoma())).findAny()
				.orElse(null);
		if (med != null) {
			return true;
		}
		return false;
	}

	public boolean verificaPessoaNaoAlergicaAoMedicamento(Medicamentos med) {
		Pessoa pes = selecionaPessoaPreviamentoCadastrada();
		boolean verifica = pes.getAlergias().stream().noneMatch(p -> p.equals(med.getContraIndicacoes()));
		if (verifica == true) {
			return true;
		}
		return false;
	}

	public void fazerPrescricao(Medicamentos med) {
		Pessoa pes = selecionaPessoaPreviamentoCadastrada();
		if (verificaMedicamentoCadastrado(med) == true && verificaSintomaEParteDoMedicamento()
				&& verificaPessoaNaoAlergicaAoMedicamento(med) == true) {
			pes.getMedicamentos().add(med);
		}
	}

	public List<Pessoa> listAllPessoa(){
		return pessoa;
	}

	public List<Medicamentos> listAllMedicamentos(){
		return medicamentos;
	}
	
	public void limparListaPessoa() {
		pessoa.clear();
	}

	public void limparListaMedicamentos() {
		medicamentos.clear();
	}
}
