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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void adicionarAutores(Autores autores) {
		this.autores.add(autores);
	}

	public void cadastra(Livros livro) {
		String titulo;
		do {
			titulo = JOptionPane.showInputDialog("Digite o titulo do livro");
		} while (validaNome(titulo) == false);
		double preco;
		do {
			preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do livro"));
		} while (validaPreco(preco) == false);
		
		livro.setTitulo(titulo);
		livro.setPreco(preco);
		
	}

	public String listarAutoresDoLivro(List<Autores> list) {
		int i = 1;
		String ret = "Os autores são: " + "\n"; //ARRUMAR VAlores nulos
		for (Autores autor : list) {
			ret += i + " - " + autor + "\n";
			i++;
		}
		return ret;
	}

	public void selecionarAutorEspecificadoNaLista(int selecaoAutor, List<Autores> list) {
		adicionarAutores(list.get(selecaoAutor - 1));
	}

	public void ListarTodosLivros(List<Livros> list) {
		String frase = "";

		for (Livros livros : list) {
			frase += "Título: " + livros.getTitulo() + " Preço: " + livros.getPreco() + "\n"
					+ livros.getAutores();
		}
		JOptionPane.showMessageDialog(null,frase);
	}

	public int validaQuantidades() {
		int quantidadeAutores;
		boolean verificaQuantidade;
		do {
			quantidadeAutores = Integer
					.parseInt(JOptionPane.showInputDialog("Escolha quantos autores de 1 a 4 você deseja"));

			if (quantidadeAutores > 0 || quantidadeAutores < 5) {
				verificaQuantidade = false;
			} else {
				verificaQuantidade = true;
			}

		} while (verificaQuantidade == true);

		return quantidadeAutores;
	}

	private boolean validaNome(String nome) {
		if (nome.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	private boolean validaPreco(double preco) {
		if (preco < 0.0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Livros: \nTítulo do livro: " + titulo + "\nPreço: R$" + String.format("%.2f", preco) + "\nAutores: "
				+ autores + "\n";
	}

}
