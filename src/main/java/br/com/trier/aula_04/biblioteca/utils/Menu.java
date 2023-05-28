package br.com.trier.aula_04.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.enums.EnumSexo;
import br.com.trier.aula_04.biblioteca.model.Autores;
import br.com.trier.aula_04.biblioteca.model.Livros;

public class Menu {

	public static int opcao() {
		String opcaoStr = "1 - Cadastrar autor" + "\n2 - Cadastrar Livros" + "\n3 - Listar todos os livros cadastrados"
				+ "\n4 - Pesquisar por autor" + "\n5 - Perquisar por faixa de valor do livro"
				+ "\n6 - Livros cujo autores são crianças(menor que 12 anos)"
				+ "\n7 - Listar todos os livros que foram escritos por gênero" + "\n8 - sair";

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));
		while (n <= 0 || n > 8) {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));

		}
		return n;
	}

	public static void cadastrarAutor(List<Autores> subList) {
		Autores autor = new Autores();
		autor.cadastrar(autor);
		subList.add(autor);
	}

	public static void cadastrarLivro(List<Livros> list, List<Autores> subList) {
		Livros livros = new Livros();
		livros.cadastra(livros);
		int n = livros.validaQuantidades();
		int selecaoAutor;
		for (int i = 0; i < n; i++) {
			selecaoAutor = Integer.parseInt(JOptionPane.showInputDialog(livros.listarAutoresDoLivro(subList)));
			livros.selecionarAutorEspecificadoNaLista(selecaoAutor, subList);
		}
		Autores autor = new Autores();
		autor.adicionar(livros);
		list.add(livros);
	}

	public static void faixaValor(List<Livros> list) {
		Double valorInicial = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de faixa inicial"));
		Double valorFinal = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de faixa final"));

		List<Livros> listaFaixaLivros = new ArrayList<>();

		for (Livros livroListVariavel : list) {
			if (livroListVariavel.getPreco() >= valorInicial && livroListVariavel.getPreco() <= valorFinal) {
				listaFaixaLivros.add(livroListVariavel);
			}
		}
		String frase = "Lista de livros por faixa de valor";
		ListLivroParaString(listaFaixaLivros, frase);
	}

	public static void pesquisarPorAutor(List<Livros> list, List<Autores> subList) {
		String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor que deseja");

		List<Livros> livro = new ArrayList<>();
		List<Autores> autor = new ArrayList<>();
		
		String guardaLivro = "";
		
			for(Livros l : list) {
				for(Autores a : subList) {
				if (a.buscarNomeAutorNoLivro(nomeAutor)) {
					autor.add(a);
				guardaLivro += " Titulo: " + l.getTitulo() + " Preço: R$" + l.getPreco() + "\n";
				}
					}
		}
		JOptionPane.showMessageDialog(null, guardaLivro);
	}

	public static void listarLivrosDeCriancas(List<Livros> list) {

		List<Livros> livro = new ArrayList<>();

		for (Livros l : list) {
			if (l.buscarAutorCriancaLivro()) {
				livro.add(l);
			}
		}
		String ret = "";
		ListLivroParaString(livro, ret);
	}
	

	public static void listarLivroPorSexoAutor(List<Livros> list) {

		List<Livros> livros = new ArrayList<>();

		EnumSexo sexo = EnumSexo.escolherSexo();

		for (Livros l : list) {
			if (l.buscarSexoAutorNoLivro(sexo) == true) {
				livros.add(l);
			}
		}
		String ret = "";
		ListLivroParaString(livros, ret);

	}
	

	private static void ListLivroParaString(List<Livros> list, String ret) {
		ret += "";
		for (Livros l : list) {
			ret += l;
		}
		JOptionPane.showMessageDialog(null, ret);
	}

}
