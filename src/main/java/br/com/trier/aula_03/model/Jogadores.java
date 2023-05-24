package br.com.trier.aula_03.model;

import br.com.trier.aula_03.Principal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter

@NonNull
@NoArgsConstructor
public class Jogadores {

	private String nome;
	private int numeroCamisa;
	private int golsMarcados;

	public void setNome(String nome) {
		if (validaNome() == true) {
			this.nome = nome;
	} else {
		
	}

	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	private boolean validaNome() {
		if (getNome().trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	private boolean validaNumCamisa(int numeroCamisa) {
		if (numeroCamisa < 0 || numeroCamisa > 99) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		} else {
			return true;
		}
	}

	private boolean validaGolsMarcados(int golsMarcados) {
		if ((numeroCamisa < 0)) {
			System.out.print("\n" + "Número de camiseta inválido. Tente novamente!");
			return false;
		}
		return true;
	}

	public Jogadores cadastrar() {
		do {
			System.out.print("Digite o nome do jogador: ");
			String nome = Principal.ler.nextLine();
		} while (validaNome(nome) != true);

		do {
			System.out.print("Digite o número da camisa: ");
			int numCamisa = Principal.ler.nextInt();
		} while (validaNumCamisa(numeroCamisa) != true);

		do {
			System.out.print("Digite a quantidade de gols marcados: ");
			int golsMarcados = Principal.ler.nextInt();
		} while (validaGolsMarcados(golsMarcados) != true);

		Jogadores jogadores = new Jogadores(nome, numeroCamisa, golsMarcados);
		return jogadores;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nNúmero camisa: " + numeroCamisa + "\nGols marcados=" + golsMarcados
				+ "\n______________";
	}

}
