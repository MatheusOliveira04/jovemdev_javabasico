package br.com.trier.aula_02.services;

public class VerificaEnumCorCarro {

	public static String verifica(int valorCor) {
		String verifica = null;
		if (valorCor == 1) {
			return "PRETO";
		}
		if (valorCor == 2) {
			verifica = "BRANCO";
		} if (valorCor == 3) {
			verifica = "PRATA";
		} if (valorCor == 4) {
			verifica = "VERMELHO";
		} if (valorCor == 5) {
			verifica = "AZUL";
		} if (valorCor == 6) {
			verifica = "OUTRO";
		}
		return verifica;
	}
}
