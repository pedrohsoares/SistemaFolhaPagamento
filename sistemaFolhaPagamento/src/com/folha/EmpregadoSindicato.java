package com.folha;

public class EmpregadoSindicato {
	private String nome;
	private String endereco;
	private double taxaSindical;
	
	public EmpregadoSindicato(String nome, String endereco, double taxaSindical) {
		this.nome = nome;
		this.endereco = endereco;
		this.taxaSindical = taxaSindical;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getTaxaSindical() {
		return taxaSindical;
	}
	public void setTaxaSindical(double taxaSindical) {
		this.taxaSindical = taxaSindical;
	}
	
	
}
