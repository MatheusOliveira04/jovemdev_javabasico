package br.com.trier.aula_02.utils;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.services.ValidaAno;

public class EscolheAtributos { 
	//Classe responsável por perguntar ao usúario as caracteristicas do carro

	public static int corSelecionada() {
		// Escolher a cor
		int valueCor = Integer.parseInt(JOptionPane
				.showInputDialog("Digite a cor " 
		+ "\n 1 - preto 2 - branco 3 - \n4 - vermelho 5 - azul 6 - outro"));
		while (valueCor < 1 || valueCor > 6) {
			valueCor = Integer.parseInt(JOptionPane.showInputDialog("Cor inválida " 
		+ "\nDigite a cor "
					+ "\n 1 - preto 2 - branco 3 - \n4 - vermelho 5 - azul 6 - outro"));
		}
		return valueCor;
	}
	
	public static int AnoSelecionar() {
		//retorna o ano digitado pelo usuário
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano(yyyy) " 
				+ "\nAno válido até 1950")); //ano do carro
				ValidaAno.validar(ano); //data será válida se for entre 1950 e 2023
				return ano;
	}
	
}
