package com.folha;


public class AgendaPagamento {
	private String nome;
	private int dia;
	private int periodo;
	
	public AgendaPagamento(String nome, int dia, int periodo) {
		this.nome = nome;
		this.dia = dia;
		this.periodo = periodo;
	}
	
	public AgendaPagamento(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
}
