package br.com.trier.aula_03.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Jogadores {

	private String nome;
	private int numeroCamisa;
	private int golsMarcados;

	public Jogadores(String nome, int numeroCamisa, int golsMarcados) {
		super();
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
		this.golsMarcados = golsMarcados;
	}

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

	public static boolean validaNome(String nome) {
		if (nome.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validaNumCamisa(int numCamisa) {
		if (numCamisa < 0 || numCamisa > 99) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		} else {
			return true;
		}
	}

	public static boolean validaGolsMarcados(int golsMarcados) {
		if ((golsMarcados < 0)) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "\nNome: " + nome + "\nNúmero camisa: " + numeroCamisa + "\nGols marcados: " + golsMarcados
				+ "\n______________";
	}

}
