package br.com.trier.aula_04.biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.model.Autores;
import br.com.trier.aula_04.biblioteca.model.Livros;
import br.com.trier.aula_04.biblioteca.utils.Menu;

public class Principal {

	public static void main(String[] args) {

		List<Livros> livroList = new ArrayList<>();
		List<Autores> autoresList = new ArrayList<>();

		boolean fim = false;
		while (fim == false) {
			int n = Menu.opcao();

			switch (n) {
			case 1:
				Menu.cadastrarAutor(autoresList);
				break;
			case 2:
				Menu.cadastrarLivro(livroList, autoresList);
				break;
			case 3:
				Livros livro = new Livros();
				livro.ListarTodosLivros(livroList);
				
				break;
			case 8: 
				fim = true;
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			}
			
		}

	}

}
