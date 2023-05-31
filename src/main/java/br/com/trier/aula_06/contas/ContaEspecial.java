package br.com.trier.aula_06.contas;

import lombok.Getter;

@Getter
public class ContaEspecial extends Conta{
	
	private Double limite;

	public ContaEspecial(Integer numero, String agencia, String correntista, Double saldo, Double limite) {
		super(numero, agencia, correntista, saldo);
		this.limite = limite;
	}

	@Override
	public boolean saque(Double sacar) {
		if(limiteParaSacar(sacar)) {
			return super.saque(sacar);
		}
		return false;
	}

	@Override
	public boolean transferencia(double valor, Conta contaDestino) {
		if(limiteParaSacar(valor)) {
		return super.transferencia(valor, contaDestino);
		}
		return false;
	}
	
	public boolean limiteParaSacar(Double valorSacar) {
		if(valorSacar <= getLimite()) {
			return true;
		}
		return false;
	}
}
