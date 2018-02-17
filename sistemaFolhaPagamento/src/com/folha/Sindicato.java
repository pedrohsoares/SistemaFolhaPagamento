package com.folha;

import java.util.ArrayList;

public class Sindicato {
	private String nome;
	private ArrayList<EmpregadoSindicato> listEmpregados;
	
	public Sindicato(String nome) {
		this.nome = nome;
		this.listEmpregados = new ArrayList<EmpregadoSindicato>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<EmpregadoSindicato> getListEmpregados() {
		return listEmpregados;
	}

	public void setListEmpregados(ArrayList<EmpregadoSindicato> listEmpregados) {
		this.listEmpregados = listEmpregados;
	}
	
	

}
