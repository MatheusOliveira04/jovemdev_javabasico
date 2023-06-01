package br.com.trier.aula_06_contas;

public class ContaUniversitaria extends Conta{
	
	public ContaUniversitaria(Integer numero, String agencia, String correntista, Double saldo) {
		super(numero, agencia, correntista, saldo);
	}

	@Override
	public boolean deposito(Double depositar) {
		if(verificaMaximoSaldo(depositar)) {
		return super.deposito(depositar);
		}
		return false;
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
		if(verificaSaldo(valor) && (contaDestino.getSaldo() + valor) <= 2000.0) {
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
	
	public boolean verificaMaximoSaldo(Double depositar) {
		if(getSaldo() + depositar <= 2000.0) {
			return true;
		}
		return false;
	}
}
