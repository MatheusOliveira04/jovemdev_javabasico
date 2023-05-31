package br.com.trier.aula_06.contas;

public class ContaUniversitaria extends Conta{
	
	public ContaUniversitaria(Integer numero, String agencia, String correntista, Double saldo) {
		super(numero, agencia, correntista, saldo);
	}

	@Override
	public boolean deposito(Double depositar) {
		if(verificaMaximoSaldo()) {
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
		if(deposito(valor)) {
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
	
	public boolean verificaMaximoSaldo() {
		if(getSaldo() <= 2000.0) {
			return true;
		}
		return false;
	}
}
