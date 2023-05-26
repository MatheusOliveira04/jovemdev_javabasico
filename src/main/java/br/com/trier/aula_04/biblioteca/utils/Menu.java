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
			String frase = "Lista de livros por faixa de valor";
			ListParaString(listaFaixaLivros, frase);
		}
	}

	public static void pesquisarPorAutor(List<Livros> list, List<Autores> subList) {
		String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor que deseja");

		String autorEscolhido = "";
		for (Autores a : subList) {
			if (a.getNome().equalsIgnoreCase(nomeAutor) == true) {
				autorEscolhido = a.getNome();
			}
		}

		String str = "";
		List<Livros> listaAdiciona = list;
		for (Livros l : list) {
			for (int i = 0; i < l.getAutores().size(); i++) {
				if (l.getAutores().get(i).getNome().equalsIgnoreCase(autorEscolhido)) {
					str += listaAdiciona.get(i).getTitulo() + " " + listaAdiciona.get(i).getPreco() + "\n";
				}
			}
		}

		JOptionPane.showMessageDialog(null, "Autor: " + autorEscolhido + "\nLivros feitos: " + str);
	}

	public static void listarLivrosDeCriancas(List<Livros> list) {
		String frase = "";

		Livros livro = new Livros();
		Autores autor = new Autores();
		int i;
		int j = -1;
		for (Livros l : list) {
			j++;
			i = 0;
			for (int k = 0; k < l.getAutores().size(); k++) {
				autor = l.getAutores().get(i);
				i++;
				if (autor.getIdade() <= 12) {
					frase += "Nome autor menor que 12 anos: \n" + autor.getNome() + "\n";
					frase += "Título: " +	list.get(j).getTitulo() + " Preço: "
							+ list.get(j).getPreco() + "\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, frase);
	}

	public static void livroEscritosSeparadosSexo(List<Livros> list, List<Autores> subList) {	
	
		EnumSexo sexo = EnumSexo.escolherSexo();
		
		String frase = "";
		Autores autor = new Autores();
		Livros livro = new Livros();

			for(Autores a : subList) {
				if(sexo == (autor.getSexo())) {
					JOptionPane.showMessageDialog(null, a.getNome() + livro);
				}
			}
	}
		
		
	
	
	private static void ListParaString(List<Livros> list, String frase) {
		frase += "";
		for (Livros livros : list) {
			frase += "Título: " + livros.getTitulo() + " Preço: " + livros.getPreco() + "\n" + livros.getAutores();
		}
		JOptionPane.showMessageDialog(null, frase);
	}

}
