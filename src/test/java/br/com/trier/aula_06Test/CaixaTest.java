package br.com.trier.aula_06Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_06.contas.Caixa;
import br.com.trier.aula_06.contas.Conta;
import br.com.trier.aula_06.contas.ContaCorrente;

public class CaixaTest {

	private List<Conta> list = new ArrayList<>();
	
	@BeforeEach
	void init() {
		list.clear();
		Conta c1 = new ContaCorrente(377,"000-1", "Correntista 1", 2000.0);
		list.add(c1);
	}
		
	@Test
	@DisplayName("Teste saque válido na Conta Corrente")
	void saqCCOk() {
		Conta c = (Conta) list.get(0);
		assertEquals(2000.0, c.getSaldo());
		boolean verifica = Caixa.sacar(1000.0, c);
		assertEquals(true, verifica);
		assertEquals(1000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste saque não válido na Conta Corrente")
	void saqCCNot() {
		Conta c = (Conta) list.get(0);
		assertEquals(2000.0, c.getSaldo());
		boolean verifica = Caixa.sacar(3000.0, c);
		assertEquals(false, verifica);
		assertEquals(2000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste deposito válido na Conta Corrente")
	void depositCCOk() {
		Conta c = (Conta) list.get(0);
		assertEquals(2000.00, c.getSaldo());
		boolean verifica = Caixa.depositar(1000.0, c);
		assertEquals(true, verifica);
		assertEquals(3000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia válido na Conta Corrente")
	void transfCCOk() {
		Conta c = (Conta) list.get(0);
		assertEquals(2000.0, c.getSaldo());
	}
}
