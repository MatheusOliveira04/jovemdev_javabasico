package br.com.trier.aula_04.biblioteca.model;

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
	

	public void cadastrar() {
		
		String nome;
		do {
		nome = JOptionPane.showInputDialog("Digite o nome");
		} while(valida() == false);
		sexo = EnumSexo.escolherSexo();
		int idade;
		do {
			idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade"));
		} while (valida() == false);
	}

	private boolean valida() {
		if(getNome().trim() == "") {
			return false;
		}
		String[] vect = getNome().split(" "); 
		if(vect.length >= 2 ) {
			return false;
		} else if (getIdade() <= 0) {
			return false;
		} else {
			return true;
		}
				}

	@Override
	public String toString() {
		return "Nome do autor: " + nome + ", Sexo: " + sexo + " Idade: " + idade
				+ "\n_____________________________________________________________\n";
	}
	
	
}
