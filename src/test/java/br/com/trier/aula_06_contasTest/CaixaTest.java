package br.com.trier.aula_06_contasTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_06_contas.Caixa;
import br.com.trier.aula_06_contas.Conta;
import br.com.trier.aula_06_contas.ContaCorrente;
import br.com.trier.aula_06_contas.ContaEspecial;
import br.com.trier.aula_06_contas.ContaUniversitaria;

public class CaixaTest {

	private Caixa caixa = new Caixa();
	
	@BeforeEach
	void init() {
		caixa.getContas().clear();
		ContaCorrente c1 = new ContaCorrente(377,"000-1", "Correntista 1", 2000.0);
		ContaCorrente c2 = new ContaCorrente(388, "000-2", "Correntista 2", 500.0);
		caixa.addConta(c1);
		caixa.addConta(c2);
		
		ContaEspecial c3 = new ContaEspecial(389, "000-3", "Correntista 3", 2000.0, 1500.0);
		ContaEspecial c4 = new ContaEspecial(390, "000-4", "Correntista 4", 2000.0, 1500.0);
		caixa.addConta(c3);
		caixa.addConta(c4);
		
		ContaUniversitaria c5 = new ContaUniversitaria(391, "000-5", "correntista 5", 2000.0);
		ContaUniversitaria c6 = new ContaUniversitaria(392, "000-5", "correntista 6", 1000.0);
		caixa.addConta(c5);
		caixa.addConta(c6);
	}
		
	@Test
	@DisplayName("Teste saque válido na Conta Corrente")
	void saqCCOk() {
		ContaCorrente c = (ContaCorrente) caixa.getContas().get(0);
		assertEquals(2000.0, c.getSaldo());
		boolean verifica = caixa.sacar(1000.0, c);
		assertEquals(true, verifica);
		assertEquals(1000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste saque inválido na Conta Corrente")
	void saqCCNot() {
		ContaCorrente c = (ContaCorrente) caixa.getContas().get(0);
		assertEquals(2000.0, c.getSaldo());
		boolean verifica = caixa.sacar(3000.0, c);
		assertEquals(false, verifica);
		assertEquals(2000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste deposito válido na Conta Corrente")
	void depositCCOk() {
		ContaCorrente c = (ContaCorrente) caixa.getContas().get(0);
		assertEquals(2000.00, c.getSaldo());
		boolean verifica = caixa.depositar(1000.0, c);
		assertEquals(true, verifica);
		assertEquals(3000.0, c.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia válido na Conta Corrente")
	void transfCCOk() {
		ContaCorrente c1 = (ContaCorrente) caixa.getContas().get(0);
		assertEquals(2000.0, c1.getSaldo());
		Conta c2 = (Conta) caixa.getContas().get(1);
		assertEquals(500.0, c2.getSaldo());
		boolean verifica  = caixa.transferir(500.0, c2, c1);
		assertEquals(true, verifica);
		assertEquals(0.0, c2.getSaldo());
		assertEquals(2500.0, c1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia inválido na Conta Corrente")
	void transfCCNot() {
		ContaCorrente c1 = (ContaCorrente) caixa.getContas().get(0);
		assertEquals(2000.0, c1.getSaldo());
		Conta c2 = (Conta) caixa.getContas().get(1);
		assertEquals(500.0, c2.getSaldo());
		boolean verifica  = caixa.transferir(600.0,c2,c1);
		assertEquals(false, verifica);
		assertEquals(500.0, c2.getSaldo());
		assertEquals(2000.0, c1.getSaldo());
	}
	
	@Test
	@DisplayName("Teste saque válido na Conta Especial")
	void saqCEOk() {
		ContaEspecial c3 = (ContaEspecial) caixa.getContas().get(2);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(1500.0, c3.getLimite());
		boolean verifica = caixa.sacar(1500.0, c3);
		assertEquals(true, verifica);
		assertEquals(500.0, c3.getSaldo());
	}
	
	@Test
	@DisplayName("Teste saque inválido na Conta Especial")
	void saqCENot() {
		ContaEspecial c3 = (ContaEspecial) caixa.getContas().get(2);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(1500.0, c3.getLimite());
		boolean verifica = caixa.sacar(3501.0, c3);
		assertEquals(false, verifica);
		assertEquals(2000.0, c3.getSaldo());
	}
	
	@Test
	@DisplayName("Teste deposito válido na Conta Especial")
	void depositCEOk() {
		ContaEspecial c3 = (ContaEspecial) caixa.getContas().get(2);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(1500.0, c3.getLimite());
		boolean verifica = caixa.depositar(1000.0, c3);
		assertEquals(true, verifica);
		assertEquals(3000.0, c3.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia válido na Conta Especial")
	void transfCEOk() {
		ContaEspecial c3 = (ContaEspecial) caixa.getContas().get(2);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(1500.0, c3.getLimite());
		ContaEspecial c4 = (ContaEspecial) caixa.getContas().get(3);
		assertEquals(2000.0, c4.getSaldo());
		assertEquals(1500.0, c4.getLimite());
		boolean verifica = caixa.transferir(1500.0, c3, c4);
		assertEquals(true, verifica);
		assertEquals(500.0, c3.getSaldo());
		assertEquals(3500.0, c4.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia inválido na Conta Especial")
	void transfCENot() {
		ContaEspecial c3 = (ContaEspecial) caixa.getContas().get(2);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(1500.0, c3.getLimite());
		ContaEspecial c4 = (ContaEspecial) caixa.getContas().get(3);
		assertEquals(2000.0, c4.getSaldo());
		assertEquals(1500.0, c4.getLimite());
		boolean verifica = caixa.transferir(3501.0, c3, c4);
		assertEquals(false, verifica);
		assertEquals(2000.0, c3.getSaldo());
		assertEquals(2000.0, c4.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de saque válido da Conta Universitaria")
	void saqCUOk() {
		ContaUniversitaria c5 = (ContaUniversitaria) caixa.getContas().get(4);
		assertEquals(2000.0, c5.getSaldo());
		boolean verifica = caixa.sacar(1500.0, c5);
		assertEquals(true, verifica);
		assertEquals(500.0, c5.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de saque inválido da Conta Universitária")
	void saqCUNot() {
		ContaUniversitaria c5 = (ContaUniversitaria) caixa.getContas().get(4);
		assertEquals(2000.0, c5.getSaldo());
		boolean verifica = caixa.sacar(2001.0, c5);
		assertEquals(false, verifica);
		assertEquals(2000.0, c5.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de deposito inválido da Conta Universitária")
	void depositCUNot() {
		ContaUniversitaria c5 = (ContaUniversitaria) caixa.getContas().get(4);
		assertEquals(2000.0, c5.getSaldo());
		boolean verifica = caixa.depositar(10.0, c5);
		assertEquals(false, verifica);
		assertEquals(2000.0, c5.getSaldo());
	}
	
	@Test
	@DisplayName("Teste de deposito válido da Conta Universitária")
	void depositCUOk() {
		ContaUniversitaria c6 = (ContaUniversitaria) caixa.getContas().get(5);
		assertEquals(1000.0, c6.getSaldo());
		boolean verifica = caixa.depositar(10.0, c6);
		assertEquals(true, verifica);
		assertEquals(1010.0, c6.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia válido na Conta Universitária")
	void transfCUOk() {
		ContaUniversitaria c5 = (ContaUniversitaria) caixa.getContas().get(4);
		assertEquals(2000.0, c5.getSaldo());
		ContaUniversitaria c6 = (ContaUniversitaria) caixa.getContas().get(5);
		assertEquals(1000.0, c6.getSaldo());
		boolean verifica = caixa.transferir(100.0, c5, c6);
		assertEquals(true, verifica);
		assertEquals(1900.0, c5.getSaldo());
		assertEquals(1100.0, c6.getSaldo());
	}
	
	@Test
	@DisplayName("Teste trânsferencia inválido na Conta Universitária")
	void transCUNot() {
		ContaUniversitaria c5 = (ContaUniversitaria) caixa.getContas().get(4);
		assertEquals(2000.0, c5.getSaldo());
		ContaUniversitaria c6 = (ContaUniversitaria) caixa.getContas().get(5);
		assertEquals(1000.0, c6.getSaldo());
		boolean verifica = caixa.transferir(100.0, c6, c5);
		assertEquals(2000.0, c5.getSaldo());
		assertEquals(1000.0, c6.getSaldo());
	}
}