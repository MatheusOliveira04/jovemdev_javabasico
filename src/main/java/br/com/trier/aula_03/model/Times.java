package br.com.trier.aula_03.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NonNull
@NoArgsConstructor
public class Times {

	private String nome;
	private List<Jogadores> jogadores = new ArrayList<>();
	

	public Times(String nome) {
		this.nome = nome;
		this.jogadores = new ArrayList<>();
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void adicionaJogadores(Jogadores jogadores) {
		this.jogadores.add(jogadores);
	}

	public void cadastrarTimes() {
		String nomeTime;
		do {
			nomeTime = JOptionPane.showInputDialog("Digite o nome do time");
			setNome(nomeTime);
		} while (valida() == false);
		
		setNome(nomeTime);
		
		Jogadores jogadores = new Jogadores();
		jogadores.cadastrarJogadores();
		
		adicionaJogadores(jogadores);
		
	}
	
	private boolean valida() {
		if (getNome().trim().equals("")) {
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
