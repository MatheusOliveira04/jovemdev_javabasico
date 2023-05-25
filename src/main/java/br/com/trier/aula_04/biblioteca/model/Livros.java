package br.com.trier.aula_04.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.utils.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Livros {

	private String titulo;
	private double preco;
	private List<Autores> autores = new ArrayList<>();

	public String listarAutores() {
		String ret = "Os autores são: \n";
		for (Autores autor : autores) {
			ret += autor + "\n";
		}
		return ret;
	}

	public void cadastra() {
		String titulo;
		do {
			titulo = JOptionPane.showInputDialog("Digite o titulo do livro");
		} while (valida() == false);
		double preco;
		do {
			preco = Integer.parseInt(JOptionPane.showInputDialog("Digite o preço do livro"));
		} while (valida() == false);
		
		//
	}

	private boolean valida() {
		if (getTitulo().trim().equals("")) {
			return false;
		} else if (getPreco() < 0.0) {
			return false;
		} else {
			return true;
		}
	}


	@Override
	public String toString() {
		return "Livros: \nTítulo do livro: " + titulo.toLowerCase() + "\nPreço: R$" + String.format("%.2f", preco)
				+ "\nAutores: " + autores + "\n";
	}

}
