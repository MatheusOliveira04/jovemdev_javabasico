package br.com.trier.aula_03.model;

import javax.swing.JOptionPane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
public class Jogadores {

	private String nome;
	private int numeroCamisa;
	private int golsMarcados;

	public String getNome() {
		return nome;
	}

	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroCamisa(int numeroCamisa) {
			this.numeroCamisa = numeroCamisa;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public void cadastrarJogadores() {
		boolean addMaisJogadores = true;
		do {
		String nomeJogador;
		do {
			nomeJogador = JOptionPane.showInputDialog("Digite o nome do jogador");
			setNome(nomeJogador);
		} while (valida() == false);
		int numCamisa;
		do {
			numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa"));
			setNumeroCamisa(numCamisa);
		} while (valida() == false);

		int golsMarcados;
		do {
			golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados"));
			setGolsMarcados(golsMarcados);
		} while (valida() == false);
		
		int adicionar;
		do {
			adicionar = Integer
					.parseInt(JOptionPane.showInputDialog("Deseja adicionar mais jogadores? \n1 - Sim \n2 - Não"));
		} while (adicionar != 1 && adicionar != 2);
		if (adicionar == 2) {
			addMaisJogadores = false;
		}

	} while (addMaisJogadores == true);
	}

	private boolean valida() {
		if (getNome().trim().equals(" ")) {
			return false;
		} else if (getNumeroCamisa() < 0 || getNumeroCamisa() > 99) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		} else if ((golsMarcados < 0)) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nNúmero camisa: " + numeroCamisa + "\nGols marcados: " + golsMarcados
				+ "\n______________";
	}

}
