package br.com.trier.aula_05_disciplinas.enums;

public enum EnumFormacao {

	GRADUACAO (1, "Graduacao"),
	ESPECIALIZACAO (2, "Especializacao"),
	POS_GRADUACAO (3, "PosGraduacao");
	
	private int codigo;
	private String descricao;
	
	private EnumFormacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static EnumFormacao verificaCodigo(int codigo) {
		for(EnumFormacao forma : EnumFormacao.values()) {
			if(forma.codigo == codigo) {
				return forma;
			}
		}
		return null;
	}
}
