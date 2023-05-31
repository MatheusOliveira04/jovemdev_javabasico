package br.com.trier.aula_06.contas;

public class Caixa {

	public static boolean sacar(Double valor, Conta conta) {
		return conta.saque(valor);
	}
	public static boolean depositar(Double valor, Conta conta) {
		return conta.deposito(valor);
	}
	
	public static boolean transferir(Double valor, Conta contaOrigem, Conta contaDestino) {
	return contaOrigem.transferencia(valor, contaDestino);
	}	
}
