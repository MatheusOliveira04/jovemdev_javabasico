package br.com.trier.aula_02;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.carros.Carro;
import br.com.trier.aula_02.enums.CorCarro;
import br.com.trier.aula_02.services.ValidaAno;
import br.com.trier.aula_02.services.VerificaEnumCorCarro;
import br.com.trier.aula_02.utils.Tela;

public class Principal {

	public static void main(String[] args) {

		List<Carro> list = new ArrayList<>();

		boolean terminar = false;
		while(terminar == false) {
			
		int numero = Tela.opcao();

		if (numero == 1) {
			String marca = JOptionPane.showInputDialog("Digite a marca do carro");

			int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano(yyyy) "
					+ "\nAno válido até 1950"));
			ValidaAno.validar(ano);
			

			String cor = JOptionPane.showInputDialog("Digite a cor "
					+ "\npreto/prata/branco/vermelho/azul/outro");
			while (VerificaEnumCorCarro.verifica((cor)) == null) {
				cor = JOptionPane.showInputDialog("Cor inválida " + "\nDigite a cor "
						+ "\npreto/prata/branco/vermelho/azul/outro");
			}
			String corToUpperCase = cor.toUpperCase();

			list.add(new Carro(marca, ano, CorCarro.valueOf(corToUpperCase)));
		} else if (numero == 2) {
				int anoInicial = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ano inicial dos carros que deseja(yyyy)"
								+ "\nAno válido até 1950"));
				
				
				while (anoInicial < 1950 || anoInicial > 2023) {
					anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Número inválido! " 
				+ "\nDigite novamente(yyyy)"));
				}
				
				int anoFinal = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ano Final dos carros que deseja(yyyy)"
								+ "\nAno válido até 1950"));
				while (anoFinal < 1950 || anoFinal > 2023) {
					anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Número inválido! " 
				+ "\nDigite novamente(yyyy)"));
				}
				
				for (Carro carro : list) {
					if(anoInicial >= carro.getAno() && anoFinal <= carro.getAno()) {
						JOptionPane.showMessageDialog(null, carro.toString());
						}
					}
				} else if(numero == 3){
						String marca = JOptionPane.showInputDialog("Digite a marca do carro");
						for (Carro carro : list) {
							if(marca.equalsIgnoreCase(carro.getMarca())) {
								JOptionPane.showMessageDialog(null, carro.toString());
							}
						}
					}
				 else if(numero == 4) {
					 String cor = JOptionPane.showInputDialog("Digite a cor "
								+ "\npreto/prata/branco/vermelho/azul/outro");
					 for (Carro carro : list) {
						if(cor.toUpperCase().equals(carro.getCor())) {
							JOptionPane.showMessageDialog(null, carro.toString());
						}
					}
					
				} else {
					if(numero == 5) {
						terminar = true;
						JOptionPane.showMessageDialog(null, "Fim");
					}
				}
			
		
		}
		
	}
}
