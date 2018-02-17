package com.folha;

import java.util.ArrayList;
import java.util.Calendar;

public class Empregado {
	private int codigoEmpregado;
	private String nome;
	private String endereco;
	private double salarioFixo;
	private double ultimoSalario;
	private Calendar dataRecebimento;
	private double taxa;
	private MetodoPagamento metodoPagamento;
	private TipoEmpregado tipoEmpregado;
	private AgendaPagamento agendaPagamento;
	private Sindicato sindicato;
	private ArrayList<CartaoPonto> listCartaoPonto;
	private ArrayList<TaxaServico> listTaxaServico;
	private ArrayList<ResultadoVenda> listResultadoVenda;

	public Empregado(int codigoEmpregado, String nome, String endereco, double salarioFixo, double taxa, AgendaPagamento agendaPagamento, MetodoPagamento metodoPagamento, TipoEmpregado tipoEmpregado, Sindicato sindicato) {
		this.codigoEmpregado = codigoEmpregado;
		this.nome = nome;
		this.endereco = endereco;
		this.salarioFixo = salarioFixo;
		this.ultimoSalario = 0;
		this.dataRecebimento = null;
		this.taxa = taxa;
		this.agendaPagamento = agendaPagamento;
		this.metodoPagamento = metodoPagamento;
		this.tipoEmpregado = tipoEmpregado;
		this.sindicato = sindicato;
		this.listCartaoPonto = new ArrayList<CartaoPonto>();
		this.listTaxaServico = new ArrayList<TaxaServico>();
		this.listResultadoVenda = new ArrayList<ResultadoVenda>();
	}

	public int getCodigoEmpregado() {
		return codigoEmpregado;
	}

	public void setCodigoEmpregado(int codigoEmpregado) {
		this.codigoEmpregado = codigoEmpregado;
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

	public Calendar getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Calendar dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public double getUltimoSalario() {
		return ultimoSalario;
	}

	public void setUltimoSalario(double ultimoSalario) {
		this.ultimoSalario = ultimoSalario;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public AgendaPagamento getAgendaPagamento() {
		return agendaPagamento;
	}

	public void setAgendaPagamento(AgendaPagamento agendaPagamento) {
		this.agendaPagamento = agendaPagamento;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public TipoEmpregado getTipoEmpregado() {
		return tipoEmpregado;
	}

	public void setTipoEmpregado(TipoEmpregado tipoEmpregado) {
		this.tipoEmpregado = tipoEmpregado;
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public ArrayList<CartaoPonto> getListCartaoPonto() {
		return listCartaoPonto;
	}

	public void setListCartaoPonto(ArrayList<CartaoPonto> listCartaoPonto) {
		this.listCartaoPonto = listCartaoPonto;
	}

	public ArrayList<TaxaServico> getListTaxaServico() {
		return listTaxaServico;
	}

	public void setListTaxaServico(ArrayList<TaxaServico> listTaxaServico) {
		this.listTaxaServico = listTaxaServico;
	}

	public ArrayList<ResultadoVenda> getListResultadoVenda() {
		return listResultadoVenda;
	}

	public void setListResultadoVenda(ArrayList<ResultadoVenda> listResultadoVenda) {
		this.listResultadoVenda = listResultadoVenda;
	}
	
	
}
