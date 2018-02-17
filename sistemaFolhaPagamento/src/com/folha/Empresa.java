package com.folha;

import java.util.ArrayList;
import java.util.Calendar;

public class Empresa {
	private String nome;
	private ArrayList<Empregado> listEmpregados;
	private Sindicato sindicato;
	private ArrayList<AgendaPagamento> listAgendaPagamento;
	
	public Empresa(String nome) {
		this.nome = nome;
		this.listEmpregados = new ArrayList<Empregado>();
		this.sindicato = new Sindicato("SINUFAL");
		this.listAgendaPagamento = new ArrayList<AgendaPagamento>();
		
		listAgendaPagamento.add(new AgendaPagamento("SEMANALMENTE",Calendar.FRIDAY,7));
		listAgendaPagamento.add(new AgendaPagamento("MENSALMENTE",1,Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)));
		listAgendaPagamento.add(new AgendaPagamento("BISEMANALMENTE",Calendar.FRIDAY,14));
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Empregado> getListEmpregados() {
		return listEmpregados;
	}

	public void setListEmpregados(ArrayList<Empregado> listEmpregados) {
		this.listEmpregados = listEmpregados;
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public ArrayList<AgendaPagamento> getListAgendaPagamento() {
		return listAgendaPagamento;
	}

	public void setListAgendaPagamento(
			ArrayList<AgendaPagamento> listAgendaPagamento) {
		this.listAgendaPagamento = listAgendaPagamento;
	}

	public boolean adicionarEmpregado(String nome, String endereco,double salarioFixo, double taxaComissao, AgendaPagamento agendaPagamento, MetodoPagamento metodoPagamento, TipoEmpregado tipoEmpregado, Sindicato sindicato){
		int size = listEmpregados.size();
		int codigoEmpregado;
		Empregado novoEmpregado;
		
		if(size == 0)
			codigoEmpregado = 1;
		else
			codigoEmpregado = listEmpregados.get(size-1).getCodigoEmpregado() + 1;
		
		for(Empregado empregado : listEmpregados)
			if(empregado.getNome().equals(nome) && empregado.getEndereco().equals(endereco))
				return false;

		novoEmpregado = new Empregado(codigoEmpregado, nome, endereco,salarioFixo, taxaComissao, agendaPagamento, metodoPagamento, tipoEmpregado, sindicato);
		
		listEmpregados.add(novoEmpregado);
		
		return true;
	}
	
	public boolean removerEmpregado(int codigoEmpregado){
		for(Empregado empregado : listEmpregados){
			if(empregado.getCodigoEmpregado() == codigoEmpregado){
				listEmpregados.remove(empregado);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarTaxaSindical(int codigoEmpregado, double taxaSindical){
		for(Empregado empregado : listEmpregados){
			if(empregado.getCodigoEmpregado() == codigoEmpregado){
				if(empregado.getSindicato() != null){
					EmpregadoSindicato novoEmpregadoSindicalizado = new EmpregadoSindicato(empregado.getNome(),empregado.getEndereco(),taxaSindical);
					sindicato.getListEmpregados().add(novoEmpregadoSindicalizado);
					break;
				}else{
					System.out.println("Este empregado não percente a nenhum sindicato!");
				}
			}
		}
	}
	
	public boolean lancarCartaoPonto(Calendar dataInicio, Calendar dataTermino, int codigoEmpregado){
		CartaoPonto novoCartaoPonto = new CartaoPonto(dataInicio, dataTermino);
		
		for(Empregado empregado : listEmpregados){
			if(empregado.getCodigoEmpregado() == codigoEmpregado && empregado.getTipoEmpregado() == TipoEmpregado.HOURLY){
				empregado.getListCartaoPonto().add(novoCartaoPonto);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean lancarResultadoVenda(Calendar dataVenda, double valor, int codigoEmpregado){
		for(Empregado empregado : listEmpregados){
			if(empregado.getCodigoEmpregado() == codigoEmpregado){
				if(empregado.getTipoEmpregado() == TipoEmpregado.COMMISSIONED){
					ResultadoVenda novoResultadoVenda = new ResultadoVenda(dataVenda, valor);
					empregado.getListResultadoVenda().add(novoResultadoVenda);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean lancarTaxaServico(String descricao, double valorTaxaServico, int codigoEmpregado){
		for(Empregado empregado : listEmpregados){
			if(empregado.getCodigoEmpregado() == codigoEmpregado){
				if(empregado.getSindicato() != null){
					TaxaServico novaTaxaServico = new TaxaServico(descricao, valorTaxaServico);
					empregado.getListTaxaServico().add(novaTaxaServico);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void rodarFolhaPagamento(){
			
	}

}
