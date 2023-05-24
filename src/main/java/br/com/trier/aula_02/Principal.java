package br.com.trier.aula_02;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.carros.Carro;
import br.com.trier.aula_02.utils.Tela;

public class Principal {

	public static void main(String[] args) {

		List<Carro> list = new ArrayList<>();

		boolean terminar = false;
		while (terminar == false) {

			int numero;
			do {
				numero = Tela.opcao();
			} while (numero < 1 || numero > 5);

			if(numero == 1) {
			Tela.cadastrar(numero, list);
			}
			else if(numero == 2) {
			Tela.listarCarroPeriodoFabricacao(list);
			} else if(numero == 3) {
			Tela.listarCarroPorMarca(list);
			} else if(numero == 4) {
			Tela.listarCarroPorCor(list);
			} else if(numero == 5) {
				terminar = true;
				JOptionPane.showMessageDialog(null, "Fim");
			}

		}

	}
}
