package br.com.trier.aula_02.services;

import javax.swing.JOptionPane;

public class ValidaAno {

	public static int validar(int ano) {
		if (ano < 1950 || ano > 2023) {
			ano = Integer.parseInt(JOptionPane.showInputDialog("Número inválido! " 
		+ "\nDigite novamente(yyyy)"));
			validar(ano);
		}
		return ano;
	}
}
