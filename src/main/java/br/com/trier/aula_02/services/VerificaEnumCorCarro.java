package br.com.trier.aula_02.services;

public class VerificaEnumCorCarro {

	public static String verifica(String cor) {
		String verifica = null;
		if (cor.toUpperCase().equals("PRETO")) {
			return "PRETO";
		}
		if (cor.toUpperCase().equals("BRANCO")) {
			verifica = "BRANCO";
		} if (cor.toUpperCase().equals("PRATA")) {
			verifica = "PRATA";
		} if (cor.toUpperCase().equals("VERMELHO")) {
			verifica = "VERMELHO";
		} if (cor.toUpperCase().equals("AZUL")) {
			verifica = "AZUL";
		} if (cor.toUpperCase().equals("OUTRO")) {
			verifica = "OUTRO";
		}
		return verifica;
	}
}
