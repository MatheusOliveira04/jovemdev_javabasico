package br.com.trier.aula_02.carros;

import br.com.trier.aula_02.enums.CorCarro;

public class Carro {

	private String marca;
	private Integer ano;
	private CorCarro cor;
	
	public Carro(String marca, Integer ano, CorCarro cor) {
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public CorCarro getCor() {
		return cor;
	}
	public void setCor(CorCarro cor) {
		this.cor = cor;
	}
	@Override
	public String toString() {
		return "Carro marca= " + marca + ", ano= " + ano + ", cor= " + cor;
	}
}
