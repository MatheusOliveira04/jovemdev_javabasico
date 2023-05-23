package br.com.trier.aula_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.trier.aula_01.model.Pessoa;
import br.com.trier.aula_01.services.ImcCalc;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);

		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Digite a quantidade de pessoas para calcular o IMC: ");
		int n = ler.nextInt();
		while(n <= 0) {
			System.out.println("Número inválido. Tente novamente!");
			n = ler.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
		
		System.out.print("Digite seu nome: ");
		ler.nextLine();
		String nome = ler.nextLine();
		
		System.out.print("Digite o sexo(m/f): ");
		char sexo = ler.next().toLowerCase().charAt(0);
		while(n <= 0) {
			System.out.println("Genero inválido. Tente novamente!");
			sexo = ler.next().toLowerCase().charAt(0);
		}
			
		System.out.print("Digite seu peso(kg): ");
		double peso = ler.nextDouble();
		System.out.print("Digite sua altura(metros): ");
		double altura = ler.nextDouble();
		
		list.add(new Pessoa(nome, sexo, peso, altura));	
		}
		
		for (Pessoa pessoa : list) {
			System.out.println("Nome: " + pessoa.getNome() 
			+ " - IMC calculo: " 
					+ String.format("%.2f", ImcCalc.calculaIMC(pessoa.getPeso(), pessoa.getAltura()))
			+ " - IMC: " 
					+ ImcCalc.mostreIMC(pessoa.getPeso(), pessoa.getAltura(), pessoa.getSexo()));
		}
		
		ler.close();
	}
}
