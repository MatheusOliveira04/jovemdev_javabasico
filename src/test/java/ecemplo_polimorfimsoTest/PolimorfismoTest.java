package ecemplo_polimorfimsoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exemplo_polimorfismo.Circulo;
import exemplo_polimorfismo.Cone;
import exemplo_polimorfismo.Forma;
import exemplo_polimorfismo.Quadrado;
import exemplo_polimorfismo.Triangulo;

public class PolimorfismoTest {

	
	private List<Forma> lista = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
	}
	
	@Test
	@DisplayName("Teste desenhar circulo")
	void desenharCirculoTest() {
		String s = lista.get(0).desenhar();
		assertEquals("Desenha um(a): Circulo", s);
	}
	
	@Test
	@DisplayName("Teste calcula área circulo")
	void calcArea() {
		Circulo c = (Circulo) lista.get(0);
		assertEquals(15, c.calculaArea());
	}
}
