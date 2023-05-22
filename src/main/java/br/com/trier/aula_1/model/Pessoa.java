package br.com.trier.aula_1.model;

public class Pessoa {

	private String nome;
	private Character sexo;
	private Double peso;
	private Double altura; // cm

	public Pessoa(String nome, Character sexo, Double peso, Double altura) {
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}	
}
