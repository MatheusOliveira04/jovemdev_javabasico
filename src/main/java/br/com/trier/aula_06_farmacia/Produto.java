package br.com.trier.aula_06_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Produto {

	private String nome;
	private Integer estoque;
	private Double valor;
	
	protected boolean baixarEstoque(int quantidade) {
		if(quantidade > 0) {
		estoque = getEstoque() - quantidade;
		return true;
		} 
		return false;
	}
	
	public boolean vender(int quantidade, Cliente c) {
		if(baixarEstoque(quantidade)) {
		double sum = quantidade * getValor();
		c.setSaldoDevedor(c.getSaldoDevedor() + sum);
		return true;
	}
		return false;
	}
}
