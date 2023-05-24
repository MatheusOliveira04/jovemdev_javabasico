package br.com.trier.aula_03.util;

import br.com.trier.aula_03.Principal;
import br.com.trier.aula_03.model.Jogadores;
import br.com.trier.aula_03.model.Time;

public class Tela {
	
	public static int opcao() {
		
		String opcaoStr = "1 - Cadastrar time" 
		+ "\n2 - Listar todos jogadores do time"
		+ "\n3 - verificar o artilheiro do campeonato" 
		+ "\n4 - verificar qual time fez mais gols no campeonato" 
		+ "\n5 - Sair";

		System.out.print(opcaoStr + ":");
		int n = Principal.ler.nextInt();
		while (n <= 0 || n > 5) {
			System.out.print("Erro! tente novamente: ");
			n = Principal.ler.nextInt();
		}
		return n;
	}
	
	public static void cadastrar() {
		
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
}
