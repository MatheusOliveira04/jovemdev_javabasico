package br.com.trier.aula_02.services;

public class CalculaPorcentagemCarros {
	
	public static int calcularPorcentagem(int totalObjInstanciados, int objCondicao) {
		int total = (objCondicao * 100) / totalObjInstanciados;
		return total;
	}
}
