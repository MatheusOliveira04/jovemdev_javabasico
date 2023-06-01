package br.com.trier.aula_06_contas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {

	private List<Conta> contas = new ArrayList<>();

	public void addConta(Conta conta) {
		contas.add(conta);
	}

	public boolean sacar(Double valor, Conta conta) {
		return conta.saque(valor);
	}

	public boolean depositar(Double valor, Conta conta) {
		return conta.deposito(valor);
	}

	public boolean transferir(Double valor, Conta contaOrigem, Conta contaDestino) {
		return contaOrigem.transferencia(valor, contaDestino);
	}
}
