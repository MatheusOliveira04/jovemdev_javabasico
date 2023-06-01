package br.com.trier.aula_06_farmacia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class farmaciaTest {

	private farmacia farmacia = new farmacia();
	
	@BeforeEach
	void init(){
		farmacia.clearListCliente();
		farmacia.clearListProdutos();
		
		Cliente c1 = new Cliente("Pessoa 1", 0.0);
		farmacia.cadastrarCliente(c1);
		
		Medicamentos m1 = new Medicamentos("Medicamento 1", 10, 2.0, true);
		Medicamentos m2 = new Medicamentos("Medicamento 2", 0, 2.0, false);
		farmacia.cadastrarProdutos(m1);
		farmacia.cadastrarProdutos(m2);
		//Medicamentos m2 = new Medicamentos("Medicamento 2", 10, 2.0, false);
	}
	
	@Test
	@DisplayName("Teste realizar venda com sucesso no Medicamento")
	void vendaMedOk() {
		Cliente c1 = farmacia.listAllClentes().get(0);
		Medicamentos m1 = (Medicamentos) farmacia.listAllProdutos().get(0);
		boolean ver = farmacia.realizarVenda(5, m1, c1);
		assertEquals(true, ver);
		assertEquals(5, m1.getEstoque());
		assertEquals(10.0, c1.getSaldoDevedor());
	}
	
	@Test
	@DisplayName("Teste realizar venda com erro, estoque menor que quantidade no Medicamento")
	void vendaMedNotEstqMenor() {
		Cliente c1 = farmacia.listAllClentes().get(0);
		Medicamentos m1 = (Medicamentos) farmacia.listAllProdutos().get(0);
		boolean ver = farmacia.realizarVenda(11, m1, c1);
		assertEquals(false, ver);
		assertEquals(10, m1.getEstoque());
		assertEquals(0.0, c1.getSaldoDevedor());
	}
	
	@Test
	@DisplayName("Teste realizar vendo com erro, estoque menor que 0")
	void vendaMedNotEstqMenorZero() {
		
	}
}
