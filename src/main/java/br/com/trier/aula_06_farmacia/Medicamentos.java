package br.com.trier.aula_06_farmacia;

import lombok.Getter;

@Getter
public class Medicamentos extends Produto{

	private Boolean receitaMedica;
	private String nomeMedico;
	
	public Medicamentos(String nome, Integer estoque, Double valor, Boolean receitaMedica) {
		super(nome, estoque, valor);
		this.receitaMedica = receitaMedica;
	}
	
	private boolean validaReceitaMedica() {
		if(receitaMedica) {
			return true;
		}
		return false;
	}

	public void setNomeMedico(String nomeMedico) {
		if(validaReceitaMedica()) {
		this.nomeMedico = nomeMedico;
		}
	}
	
	
}
