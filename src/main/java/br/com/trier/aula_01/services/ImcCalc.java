package br.com.trier.aula_01.services;

public class ImcCalc {

	public static double calculaIMC(double peso, double altura) {
		return peso / (Math.pow(altura, 2));
	}

	public static String mostreIMC(double peso, double altura, char sexo) {
		double imc = calculaIMC(peso, altura);
		String resultadoIMC = null;
		
		if (sexo == 'm') {
			if (imc < 20.7) {
				resultadoIMC = "Abaixo do peso";
			} else if (imc >= 20.7 && imc <= 26.4) {
				resultadoIMC = "Peso ideal";
			} else if (imc >= 26.5 && imc <= 27.8) {
				resultadoIMC = "Pouco acima do peso";
			} else if (imc >= 27.9 && imc <= 31.1) {
				resultadoIMC = "Acima do Peso";
			} else {
				resultadoIMC = "Obesidade";
			}
		} else if (sexo == 'f') {
			if (imc < 19.1) {
				resultadoIMC = "Abaixo do peso";
			} else if (imc >= 19.1 && imc <= 25.8) {
				resultadoIMC = "Peso ideal";
			} else if (imc >= 25.9 && imc <= 27.3) {
				resultadoIMC = "Pouco acima do peso";
			} else if (imc >= 27.4 && imc <= 32.3) {
				resultadoIMC = "Acima do Peso";
			} else {
				resultadoIMC = "Obesidade";
			}
		}
		return resultadoIMC;
	}
}
