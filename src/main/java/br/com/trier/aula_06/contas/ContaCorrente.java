package br.com.trier.aula_06.contas;

public class ContaCorrente extends Conta{

	public ContaCorrente(Integer numero, String agencia, String correntista, Double saldo) {
		super(numero, agencia, correntista, saldo);
	}

	@Override
	public boolean saque(Double sacar) {
		if(verificaSaldo(sacar)) {
			return super.saque(sacar);
		}
		return false;
	}

	@Override
	public boolean transferencia(double valor, Conta contaDestino) {
		if(saque(valor)) {
		return super.transferencia(valor, contaDestino);
		}
		return false;
	}

	public boolean verificaSaldo(Double valor) {
		if(valor <= getSaldo()) {
			return true;
		}
		return false;
	}
}
