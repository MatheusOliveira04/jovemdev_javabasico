package br.com.trier.aula_03.util;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_03.model.Jogadores;
import br.com.trier.aula_03.model.Time;

public class Tela {

	public static int opcao() {

		String opcaoStr = "1 - Cadastrar time" + "\n2 - Listar todos jogadores do time"
				+ "\n3 - verificar o artilheiro do campeonato" + "\n4 - verificar qual time fez mais gols no campeonato"
				+ "\n5 - Sair";

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));
		while (n <= 0 || n > 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, opcaoStr));

		}
		return n;
	}

	public static void Cadastrar(List<Time> list) {

		String nome;
		do {
			nome = JOptionPane.showInputDialog("Digite o nome do time");

		} while (Time.validaNome(nome) != true);

		Time time = new Time(nome);
		list.add(time);

		boolean addMaisJogadores = true;
		do {
			String nomeJogador;
			do {
				nomeJogador = JOptionPane.showInputDialog("Digite o nome do jogador");
			} while (Jogadores.validaNome(nomeJogador) != true);

			int numCamisa;
			do {
				numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa"));
			} while (Jogadores.validaNumCamisa(numCamisa) != true);

			int golsMarcados;
			do {
				golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados"));
			} while (Jogadores.validaGolsMarcados(golsMarcados) != true);

			Jogadores jogadores = (new Jogadores(nomeJogador, numCamisa, golsMarcados));
			time.adicionaJogadores(jogadores);

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

	public static void listarJogadoresDoTime(List<Time> list) {
		String nome;
		do {
			nome = JOptionPane.showInputDialog("Digite o nome do time");
		} while (Time.validaNome(nome) != true);

		String timeStr = "Jogadores do time: " + nome;
		String objSelecionados = "";
		for (Time time : list) {
			if (nome.toLowerCase().equals(time.getNome().toLowerCase())) {
				objSelecionados += time.getJogadores() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, timeStr + objSelecionados);
	}

	public static void artilheiroDoCampeonato(List<Time> list) {
		String jogadorStr = null;
		int maiorArtilheiro = 0;
		for (Time time : list) {
			List<Jogadores> subList = time.getJogadores();
			for (Jogadores jogadores : subList) {
				if (jogadores.getGolsMarcados() > maiorArtilheiro) {
					maiorArtilheiro = jogadores.getGolsMarcados();
					jogadorStr = jogadores.toString();
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Maior artilheiro do campeonato: " + jogadorStr);
	}

	public static void timeMaisMarcouGols(List<Time> list) {
		int soma = 0;
		String verificaTime = null;
		String timeStr = "";
		
		
		for (Time time : list) {
			if (time.getNome() == verificaTime || verificaTime == null) {
				verificaTime = time.getNome();
				List<Jogadores> subList = time.getJogadores();
				for (Jogadores jogadores : subList) {
					soma += jogadores.getGolsMarcados();
				}
				timeStr = "Nome do time: " + time.getNome() + " - gols marcados: " + soma;
			} 
		}
		JOptionPane.showMessageDialog(null, timeStr);
	}
}
