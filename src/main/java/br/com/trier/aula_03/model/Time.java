package br.com.trier.aula_03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.trier.aula_01.Principal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Time {

	private static Scanner ler = new Scanner(System.in);

	private String nome;
	private List<Jogadores> jogadores;

	public Time(String nome, List<Jogadores> jogadores) {
		this.nome = nome;
		this.jogadores = new ArrayList<>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionaJogadores(Jogadores jogadores) {
		this.jogadores.add(jogadores);
	}

	private boolean validaNome(String nome) {
		if (nome.trim().equals("")) {
			System.out.print("\nInválido, tente novamente!");
			return false;
		} else {
			return true;
		}
	}

	public void cadastrar() {
		do {
		System.out.print("Digite o nome do time: ");
		String nome = br.com.trier.aula_03.Principal.ler.nextLine();
		} while(validaNome(nome) != true);
		
		Jogadores jogadores = new Jogadores(jogadores.cadastrar().getNome(),jogadores.cadastrar().getNumeroCamisa(),jogadores.cadastrar().getGolsMarcados());
		
		Time time = new Time(nome, );

	}

	@Override
	public String toString() {
		return "Nome do time: " + nome + "\nJogadores: " + jogadores + "\n___________";
	}
}
