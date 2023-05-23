package br.com.trier.aula_02.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.carros.Carro;
import br.com.trier.aula_02.enums.CorCarro;
import br.com.trier.aula_02.services.VerificaEnumCorCarro;

public class Tela {

	public static int opcao() {
		String opcaoStr = "1 - Cadastrar " + "\n2 - Listar carros por período de fabricação"
				+ "\n3 - Listar Carros por marca" + "\n4 - Listar carros por cor" + "\n5 - Sair";

		int n = Integer.parseInt(JOptionPane.showInputDialog(opcaoStr));
		while (n <= 0 || n > 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog("Erro. Tente novamente!\n1" + opcaoStr));
		}

		return n;
	}
}
