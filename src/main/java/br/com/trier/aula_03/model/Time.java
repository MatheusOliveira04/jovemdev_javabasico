package br.com.trier.aula_03.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Time {

	private String nome;
	private List<Jogadores> jogadores;
	
	public Time() {
		super();
	}

	public Time(String nome) {
		this.nome = nome;
		this.jogadores = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Jogadores> getJogadores() {
		return jogadores;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionaJogadores(Jogadores jogadores) {
		this.jogadores.add(jogadores);
	}

	public static boolean validaNome(String nome) {
		if (nome.trim().equals("") || nome.equals(null)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Nome do time: " + nome + "\nJogadores: " + jogadores + "\n_________________ ";
	}
}
