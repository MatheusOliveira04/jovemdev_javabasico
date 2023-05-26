package br.com.trier.aula_04.biblioteca.utils;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.model.Autores;
import br.com.trier.aula_04.biblioteca.model.Livros;

public class Menu {

	public static int opcao() {
		String opcaoStr = "1 - Cadastrar autor" + "\n2 - Cadastrar Livros" + "\n3 - Listar todos os livros cadastrados"
				+ "\n4 - Pesquisar por autor" + "\n5 - Perquisar por faixa de valor do livro"
				+ "\n6 - Livros cujo autores são crianças(menor que 12 anos)"
				+ "\n7 - Listar todos os livros que foram escritos por gênero" + "\n8 - sair";

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));
		while (n <= 0 || n > 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));

		}
		return n;
	}

	public static void cadastrarAutor(List<Autores> list) {
		Autores autor = new Autores();
		autor.cadastrar(autor);
		list.add(autor);
	}

	public static void cadastrarLivro(List<Livros> list ,List<Autores> subList) {
		Livros livros = new Livros();
		livros.cadastra(livros);
		int n = livros.validaQuantidades();
		int selecaoAutor;
		for (int i = 0; i < n; i++) {
			selecaoAutor = Integer.parseInt(JOptionPane
					.showInputDialog(livros.listarAutoresDoLivro(subList)));
			livros.selecionarAutorEspecificadoNaLista(selecaoAutor, subList);		
		}
		list.add(livros);
	}
	
}
