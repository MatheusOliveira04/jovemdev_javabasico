package br.com.trier.aula_06_farmacia;

public class Perfumes extends Produto{

	public Perfumes(String nome, Integer estoque, Double valor) {
		super(nome, estoque, valor);
	}

	private boolean verificaEstoque() {
		if(getEstoque() > 0) {
			return true;
		}
		return false;
	}
	
	private boolean verificaEstoqueMaiorRetirar(int quantidade) {
		if(getEstoque() >= quantidade) {
			return true;
		}
		return false;
	}
	
	private boolean verificaDividas(Cliente c) {
		if(c.getSaldoDevedor() < 300.0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean baixarEstoque(int quantidade) {
		if(verificaEstoqueMaiorRetirar(quantidade) && verificaEstoque()) { 
		return super.baixarEstoque(quantidade);
		}
		return false;
	}

	@Override
	public boolean vender(int quantidade, Cliente c) {
		if(baixarEstoque(quantidade) && verificaDividas(c)) {
		return super.vender(quantidade, c);
		}
		return false;
	}
	
	
}
