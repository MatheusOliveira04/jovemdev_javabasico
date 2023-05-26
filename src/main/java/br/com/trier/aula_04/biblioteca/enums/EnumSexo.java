package br.com.trier.aula_04.biblioteca.enums;

import javax.swing.JOptionPane;

public enum EnumSexo {

	MASCULINO (1, "masculino"),
	FEMININO (2, "feminino");
	
	private int codigo;
	private String descricao;
	
	private EnumSexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static EnumSexo buscaPorCodigo(int codigo) {
		for(EnumSexo sexo : EnumSexo.values()) {
			if(codigo == sexo.codigo) {
				return sexo;
			}
		}
		return null;
	}
	
	public static EnumSexo escolherSexo() {
		int escolha;
		do {
		String menu = "Escolha um sexo";
		for(EnumSexo sexo : EnumSexo.values()) {
			menu += "\n" + sexo.codigo + " - " + sexo.descricao;
		}
		escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		} while (validaSexo(escolha) == false);
		return buscaPorCodigo(escolha);
	}
	
	private static boolean validaSexo(int escolha) {
		for(EnumSexo sexo : EnumSexo.values()) {
			if(escolha == sexo.codigo) {
				return true;
			}
		}
		return false;
	}
}
