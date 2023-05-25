package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_03.model.Time;
import br.com.trier.aula_03.util.Tela;

public class Principal {

	public static void main(String[] args) {
		
		List<Time> list = new ArrayList<>();
		
		boolean fim = false;
		while (fim == false) {

			int n = Tela.opcao();

			switch (n) {
			case 1:
				Tela.Cadastrar(list);
				break;
			case 2:
				Tela.listarJogadoresDoTime(list);	
				break;
			case 3:
				Tela.artilheiroDoCampeonato(list);
				break;
				case 4: 
					Tela.timeMaisMarcouGols(list);
					break;
			case 5 :
				fim = true;
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			}
		}
	}

}
