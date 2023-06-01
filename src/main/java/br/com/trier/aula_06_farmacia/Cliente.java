package br.com.trier.aula_06_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cliente {

	private String nome;
	@Setter
	private Double saldoDevedor;
	
	public void pagarConta(double valor) {
		saldoDevedor = getSaldoDevedor() - valor;
	}
}
