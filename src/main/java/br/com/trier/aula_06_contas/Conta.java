package br.com.trier.aula_06_contas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Conta {

	private Integer numero;
	private String agencia;
	private String correntista;
	private Double saldo;
	
	public boolean deposito(Double depositar) {
		saldo += depositar;
		return true;
	}
	
	public boolean saque(Double sacar) {
		saldo -= sacar;
		return true;
	}
	
	public boolean transferencia(double valor, Conta contaDestino) {
		saque(valor);
		contaDestino.deposito(valor);
		return true;	
	}
}
