package br.com.trier.aula_03.util;

import java.sql.Time;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_03.model.Jogadores;
import br.com.trier.aula_03.model.Times;

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

	public static void listarJogadoresDoTime(List<Times> list) {
		String nome;
		do {
			nome = JOptionPane.showInputDialog("Digite o nome do time");
		} while (nome.trim().equals(""));

		String timeStr = "Jogadores do time: " + nome;
		String objSelecionados = "";
		for (Times time : list) {
			if (nome.toLowerCase().equals(time.getNome().toLowerCase())) {
				objSelecionados += time.getJogadores() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, timeStr + objSelecionados);
	}

	public static void artilheiroDoCampeonato(List<Times> list) {
		String jogadorStr = null;
		int maiorArtilheiro = 0;
		for (Times time : list) {
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

	public static void timeMaisMarcouGols(List<Times> list) {
		int soma = 0;
		String verificaTime = null;
		String timeStr = "";
		
		
		for (Times time : list) {
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
