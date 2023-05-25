package br.com.trier.aula_04.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.model.Autores;
import br.com.trier.aula_04.biblioteca.model.Livros;

public class Menu {

	public static int opcao() {
		String opcaoStr = "1 - Cadastrar autor" + "\n2 - Cadastrar Livros" + "\n3 Listar todos os livros cadastrados"
				+ "\n4 - Pesquisar por autor" + "\n5 Perquisar por faixa de valor do livro"
				+ "\n6 - Livros cujo autores são crianças(menor que 12 anos)"
				+ "\n7 Listar todos os livros que foram escritos por gênero" + "\n8 sair";
		
		int n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));
		while (n <= 0 || n > 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));

		}
		return n;
	}
	
	public static void cadastrarAutor(List<Autores> list) {
		Autores autor = new Autores();
		autor.cadastrar();
		list.add(autor);
	}

	public static void cadastrarLivro(List<Livros> list) {
		Livros livros = new Livros();
		livros.cadastra();
	//	livros.getAutores().add(adicionarAutores(list));
		list.add(livros);
	}
	
	private static String escolhaAutores(List<Autores> list) {
		String ret = "Escolha entre esses autores:";
		int i = 0;
		for (Autores autor : list) {
			ret += (i + 1) + " - " + autor + "\n";
		}
		return ret;
	} 
	//public Autores adicionarAutores(List<Autores> list) {
	
	public static int validaQuantidades() {
		int quantidadeAutores;
		boolean verificaQuantidade;
		do {
			quantidadeAutores = Integer.parseInt(JOptionPane.showInputDialog("Escolha quantos autores de 1 a 4 você deseja"));

			if (quantidadeAutores < 1 || quantidadeAutores > 4) {
				verificaQuantidade = false;
			}
			verificaQuantidade = true;
		
		} while(verificaQuantidade = true);
		
		return quantidadeAutores;
		
		/*int autorSelecionado;
		do {
		autorSelecionado = Integer.parseInt(JOptionPane.showInputDialog(Menu.escolhaAutores(list)));
		} while(autorSelecionado < 1 || autorSelecionado > list.size() - 1);
		
		for(int i = 0; i < autorSelecionado; i++) {
		int escolhaAutores = Integer.parseInt(JOptionPane.showInputDialog(Menu.escolhaAutores(list)));
		//subList.add(list.get(escolhaAutores - 1)); 
		}*/
		
	}

}
