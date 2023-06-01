package br.com.trier.aula_06_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {

	private String nome;
	private Integer estoque;
	private Double valor;
	
	public boolean baixarEstoque(int quantidade) {
		estoque -= quantidade;
		return true;
	}
}
