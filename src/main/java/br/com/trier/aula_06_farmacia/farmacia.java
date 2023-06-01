package br.com.trier.aula_06_farmacia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class farmacia {

	List<Cliente> clientes = new ArrayList<>();
	List<Produto> produtos = new ArrayList<>();
	
	public void cadastrarCliente(Cliente c) {
		clientes.add(c);
	}
	
	public void cadastrarProdutos(Produto p) {
		produtos.add(p);
	}
	
	public boolean realizarVenda(int quantidade, Produto p, Cliente c) {
		return p.vender(quantidade, c);
	}
	
	public void pagarContaCliente(double valor, Cliente c) {
		c.pagarConta(0);
	}
	
	public List<Cliente> listAllClentes(){
		return clientes;
	}
	
	public List<Produto> listAllProdutos(){
		return produtos;
	}
	
	public void clearListCliente() {
		clientes.clear();
	}
	
	public void clearListProdutos() {
		produtos.clear();
	}
	
}
