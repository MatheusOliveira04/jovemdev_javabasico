package br.com.trier.aula_04.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_04.biblioteca.enums.EnumSexo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Autores {

	private String nome;
	private EnumSexo sexo;
	private int idade;
	private List<Livros> livros = new ArrayList<>();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void adicionar(Livros livro) {
		livros.add(livro);
	}
	
	public void cadastrar(Autores autor) {

		String nome;
		do {
			nome = JOptionPane.showInputDialog("Digite o nome");
		} while (validaNome(nome) == false);
		sexo = EnumSexo.escolherSexo();
		int idade;
		do {
			idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade"));
		} while (validaIdade(idade) == false);
		
		autor.setNome(nome);
		autor.setIdade(idade);
		autor.setSexo(sexo);
		
	}
	public boolean buscarNomeAutorNoLivro(String nome) {
		boolean contem = false;
			if(getNome().equalsIgnoreCase(nome)) {
				contem = true;
			} else {
				contem = false;
			
		}
		return contem;
	}
	
	private boolean validaNome(String nome) {
		if (nome.trim() == "") {
			return false;
		}
		String[] vect = nome.split(" ");
		if (vect.length > 2) {
			return false;
		} else {
			return true;
		}
	}

	private boolean validaIdade(int idade) {
		if (idade <= 0 || idade > 150) {
			return false;
		} else {
			return true;
		}
	}

	
	@Override
	public String toString() {
		return "Nome do autor: " + nome + ", Sexo: " + sexo + " Idade: " + idade
				+ "\n";
	}

}
