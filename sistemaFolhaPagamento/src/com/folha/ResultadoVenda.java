package com.folha;

import java.util.Calendar;

public class ResultadoVenda {
	private Calendar dataVenda;
	private double valorVenda;
	
	public ResultadoVenda(Calendar dataVenda, double valorVenda){
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
	}
	
	public Calendar getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
}
