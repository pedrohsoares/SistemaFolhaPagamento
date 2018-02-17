package com.folha;

import java.util.Calendar;
import java.util.Scanner;


public class Principal {
	
	public static boolean cadastrarEmpregado(Empresa empresa){
		Scanner input = new Scanner(System.in);
		
		AgendaPagamento tipoAgenda = null;
		TipoEmpregado tipoEmpregado = null;
		MetodoPagamento metodoPagamento = null;
		Sindicato sindicato = null;
		
		
		System.out.println("CADASTRO DE NOVO EMPREGADO\nINFORME O NOME DO EMPREGADO:");
		String nome = input.nextLine();
		
		System.out.println("INFORME O ENDEREÇO DO EMPREGADO:");
		String endereco = input.nextLine();
		
		
		System.out.println("ESCOLHA O METODO DE PAGAMENTO: \n\t1.CHEQUE PELOS CORREIOS\n\t2.CHEQUE EM MÃƒOS\n\t3.DEPOSITO BANCÃ�RIO");
		int opcaoPagamento = input.nextInt();
		
		switch(opcaoPagamento){
			case 1:
				metodoPagamento = MetodoPagamento.CHEQUE_CORREIOS;
				break;
			case 2:
				metodoPagamento = MetodoPagamento.CHEQUE_MAOS;
				break;
			case 3:
				metodoPagamento = MetodoPagamento.DEPOSITO_BANCARIO;
				break;
		}
		
		System.out.println("ESCOLHA O TIPO DE EMPREGADO: \n\t1.HORISTA\n\t2.ASSALARIADO\n\t3.COMISSIONADO");
		int opcaoTipoFuncionario = input.nextInt();
		double taxa = 0,salarioFixo = 0;
		
		switch(opcaoTipoFuncionario){
			case 1:
				System.out.println("Informe a taxa normal de hora trabalhada:");
				taxa = input.nextDouble();
				tipoEmpregado = TipoEmpregado.HOURLY;
				tipoAgenda = empresa.getListAgendaPagamento().get(0);
				
				break;
			case 2:
				System.out.println("Informe o salário fixo:");
				salarioFixo = input.nextDouble();
				tipoEmpregado = TipoEmpregado.SALARIED;
				tipoAgenda = empresa.getListAgendaPagamento().get(1);
				break;
			case 3:
				System.out.println("Informe o salario fixo:");
				salarioFixo = input.nextDouble();
				System.out.println("Informe a taxa de comissão:");
				taxa = input.nextDouble();
				tipoEmpregado = TipoEmpregado.COMMISSIONED;
				tipoAgenda = empresa.getListAgendaPagamento().get(2);
				break;
		}
		
		System.out.println("O EMPREGADO É SINDICALIZADO? \n\t1.SIM\n\t2.NÃƒO");
		int opcaoSindicato = input.nextInt();
		
		if(opcaoSindicato == 1)
			sindicato = empresa.getSindicato();
		
		
		return empresa.adicionarEmpregado(nome, endereco, salarioFixo, taxa, tipoAgenda, metodoPagamento, tipoEmpregado, sindicato);
	}
	
	public static boolean removerEmpregado(Empresa empresa){
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o código do usuário que você deseja remover: ");
		int codigo = input.nextInt();
		
		return empresa.removerEmpregado(codigo);
	}
	
	public static boolean lancarCartao(Empresa empresa){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		int codigoEmpregado = input.nextInt();
		
		System.out.println("Informe a hora de chegada:");
		int hora = input.nextInt();
		
		System.out.println("Informe o minuto de chegada:");
		int minuto = input.nextInt();
		
		Calendar dataChegada = Calendar.getInstance();
		dataChegada.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, hora, minuto);
		
		System.out.println("Informe a hora de chegada:");
		int horaSaida = input.nextInt();
		
		System.out.println("Informe o minuto de chegada:");
		int minutoSaida = input.nextInt();
		
		Calendar dataSaida = Calendar.getInstance();
		dataSaida.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, horaSaida, minutoSaida);
		
		return empresa.lancarCartaoPonto(dataChegada, dataSaida, codigoEmpregado);
	}
	
	public static boolean lancarVenda(Empresa empresa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		int codigoEmpregado = input.nextInt();
		
		System.out.println("Informe o valor da venda");
		double valor = input.nextDouble();
		
		System.out.println("Informe o dia da venda");
		int dia = input.nextInt();
		
		System.out.println("Informe o mes da venda");
		int mes = input.nextInt();
		
		System.out.println("Informe o ano da venda");
		int ano = input.nextInt();
		
		
		Calendar dataVenda = Calendar.getInstance();
		dataVenda.set(ano, mes, dia);
		
		return empresa.lancarResultadoVenda(dataVenda, valor, codigoEmpregado);
	}
	
	public static boolean lancarTaxaServico(Empresa empresa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		int codigoEmpregado = input.nextInt();
		
		System.out.println("Informe a descrição da taxa de serviço:");
		String descricao = input.nextLine();
		
		System.out.println("Informe o valor da taxa de serviço:");
		double valorTaxaServico = input.nextDouble();
		
		return empresa.lancarTaxaServico(descricao, valorTaxaServico, codigoEmpregado);
	}
	
	public static boolean criarAgendaPagamento(Empresa empresa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o nome da nova agenda");
		String nome = input.nextLine();
		
		System.out.println("Informe o dia do pagamento:");
		int dia = input.nextInt();
		
		System.out.println("Informe o intervalo de dias pra o novo pagamento:");
		int periodo = input.nextInt();
		
		AgendaPagamento novaAgenda = new AgendaPagamento(nome, dia, periodo);
		
		empresa.getListAgendaPagamento().add(novaAgenda);
		return true;
	}
	
	public static boolean mudarAgendaPagamento(Empresa empresa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		int codigoEmpregado = input.nextInt();
		
		for(Empregado empregado : empresa.getListEmpregados()) {
			if(empregado.getCodigoEmpregado() == codigoEmpregado) {
				System.out.println("A agenda atual é: " + empregado.getAgendaPagamento().getNome());
				System.out.println("Escolha uma nova agenda: ");
				for(int iterator = 0; iterator < empresa.getListAgendaPagamento().size();iterator++) {
					System.out.println("\t" + (iterator+1) + "." + empresa.getListAgendaPagamento().get(iterator).getNome());
				}
				
				int opcao = input.nextInt();
				while(opcao > empresa.getListAgendaPagamento().size()) {
					System.out.println("Informe uma opção válida.Digite novamente:");
					opcao = input.nextInt();
				}
				
				empregado.setAgendaPagamento(empresa.getListAgendaPagamento().get(opcao-1));
				return true;
			}
		}
		
		
		return false;
	}
	
	public static boolean alterarEmpregado(Empresa empresa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		int codigoEmpregado = input.nextInt();
		
		System.out.println("Informe o dado que você deseja alterar:\n\t1.Nome\n\t2.Endereço"
				+ "\n\t3.Tipo de Empregado\n\t4.Método de Pagamento\n\t5.Sindicato");
		
		int opcao = input.nextInt();
		
		switch(opcao) {
			case 1:
				System.out.println("Informe o novo nome desejado:");
				String nome = input.nextLine();
				for(Empregado empregado : empresa.getListEmpregados()) {
					if(empregado.getCodigoEmpregado() == codigoEmpregado) {
						empregado.setNome(nome);
						
						return true;
					}
				}
					
				break;
			case 2:
				System.out.println("Informe o novo endereço desejado:");
				String endereco = input.nextLine();
				for(Empregado empregado : empresa.getListEmpregados()) {
					if(empregado.getCodigoEmpregado() == codigoEmpregado) {
						empregado.setEndereco(endereco);
						return true;
					}
				}
				break;
			case 3:
				System.out.println("Informe o novo tipo de empregado:\n\t1.Horista\n\t2.Assalariado\n\t3.Comissionado");
				
				int opcaoTipoEmpregado = input.nextInt();
				
				for(Empregado empregado : empresa.getListEmpregados()) {
					if(empregado.getCodigoEmpregado() == codigoEmpregado) {
						if(opcaoTipoEmpregado == 1)
							empregado.setTipoEmpregado(TipoEmpregado.HOURLY);
						else if(opcaoTipoEmpregado == 2)
							empregado.setTipoEmpregado(TipoEmpregado.SALARIED);
						else if(opcaoTipoEmpregado == 3)
							empregado.setTipoEmpregado(TipoEmpregado.COMMISSIONED);
						else {
							System.out.println("Opção invalida");
							return false;
						}
						return true;
					}
				}
				break;
			case 4:
				System.out.println("Informe o novo metodo de pagamento:\n\t1.Cheque pelos Correios\n\t2.Cheque em mãos\n\t3.Deposito Bancário");
				
				int opcaoMetodoPagamento = input.nextInt();
				
				for(Empregado empregado : empresa.getListEmpregados()) {
					if(empregado.getCodigoEmpregado() == codigoEmpregado) {
						if(opcaoMetodoPagamento == 1)
							empregado.setMetodoPagamento(MetodoPagamento.CHEQUE_CORREIOS);
						else if(opcaoMetodoPagamento == 2)
							empregado.setMetodoPagamento(MetodoPagamento.CHEQUE_MAOS);
						else if(opcaoMetodoPagamento == 3)
							empregado.setMetodoPagamento(MetodoPagamento.DEPOSITO_BANCARIO);
						else {
							System.out.println("Opção invalida");
							return false;
						}
						return true;
					}
				}
		
				break;
			case 5:
				System.out.println("Deseja adicionar o sindicato:\n\t1.Sim\n\t2.Não");
				int opcaoSindicato = input.nextInt();
				
				for(Empregado empregado : empresa.getListEmpregados()) {
					if(empregado.getCodigoEmpregado() == codigoEmpregado) {
						if(opcaoSindicato == 1){
							if(empregado.getSindicato() == null) {
								empregado.setSindicato(empresa.getSindicato());
								EmpregadoSindicato novoEmpregadoSindicato = new EmpregadoSindicato(empregado.getNome(), empregado.getEndereco(), 0);
								empresa.getSindicato().getListEmpregados().add(novoEmpregadoSindicato);
							}
							
							System.out.println("Informe a taxa sindical:");
							double taxa = input.nextDouble();
							
							for(EmpregadoSindicato iterator : empresa.getSindicato().getListEmpregados()) {
								if(iterator.getNome().equals(empregado.getNome()) && iterator.getEndereco().equals(empregado.getEndereco())) {
									iterator.setTaxaSindical(taxa);
									break;
								}
							}
							
						}else {
							if(empregado.getSindicato() != null) {
								empregado.setSindicato(null);
								for(EmpregadoSindicato iterator : empresa.getSindicato().getListEmpregados()) {
									if(iterator.getNome().equals(empregado.getNome()) && iterator.getEndereco().equals(empregado.getEndereco())) {
										empresa.getSindicato().getListEmpregados().remove(iterator);
										break;
									}
								}
							}
							
						}
						break;
					}
				}
				break;
			default:
				System.out.println("Esta não é uma opção válida!");
		}
		
		return true;
	}
	
	public static void folhaPagamento(Empresa empresa) {
		Calendar dataAtual = Calendar.getInstance();
		
		for(Empregado empregado : empresa.getListEmpregados()) {
			double salarioTotal = 0.0;
			if(empregado.getTipoEmpregado() == TipoEmpregado.HOURLY && dataAtual.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				for(CartaoPonto cartaoPonto : empregado.getListCartaoPonto()) {
					int hour = cartaoPonto.getDataHoraTermino().get(Calendar.HOUR_OF_DAY) - cartaoPonto.getDataHoraInicio().get(Calendar.HOUR_OF_DAY);
					if(hour > 8) {
						salarioTotal += (hour-8) * (empregado.getTaxa()*1.5);
						salarioTotal += 8 * empregado.getTaxa();
					}else {
						salarioTotal += hour * empregado.getTaxa();
					}
				}
				
				empregado.getListCartaoPonto().clear();
				
				empregado.setUltimoSalario(salarioTotal);
				empregado.setDataRecebimento(dataAtual);
			}
			
			if(empregado.getTipoEmpregado() == TipoEmpregado.SALARIED) {
				int ultimoDia = dataAtual.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				Calendar novaData = Calendar.getInstance();
				novaData.set(dataAtual.get(Calendar.YEAR), dataAtual.getActualMinimum(Calendar.MONTH), ultimoDia);
				
				if(novaData.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					ultimoDia--;
				
				if(novaData.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
					ultimoDia-=2;
				
				
				if(dataAtual.get(Calendar.DAY_OF_MONTH) == ultimoDia) {
					empregado.setUltimoSalario(empregado.getSalarioFixo());
					empregado.setDataRecebimento(dataAtual);
				}
			}
			
			if(empregado.getTipoEmpregado() == TipoEmpregado.COMMISSIONED) {
				if(empregado.getDataRecebimento() == null) {
					if(dataAtual.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						double totalSalario = 0.0;
						
						for(ResultadoVenda venda : empregado.getListResultadoVenda()) {
							totalSalario += (venda.getValorVenda() * empregado.getTaxa());
						}
						
						totalSalario += (empregado.getSalarioFixo()/2);
						empregado.setUltimoSalario(totalSalario);
						empregado.setDataRecebimento(dataAtual);
					}
				}else {
					Calendar novaData = empregado.getDataRecebimento();
					novaData.add(Calendar.DAY_OF_YEAR, 14);
					
					if(dataAtual.get(Calendar.DAY_OF_YEAR) == novaData.get(Calendar.DAY_OF_YEAR)) {
						double totalSalario = 0.0;
						
						for(ResultadoVenda venda : empregado.getListResultadoVenda()) {
							totalSalario += (venda.getValorVenda() * empregado.getTaxa());
						}
						
						totalSalario += (empregado.getSalarioFixo()/2);
						empregado.setUltimoSalario(totalSalario);
						empregado.setDataRecebimento(dataAtual);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Empresa empresa = new Empresa("UFAL");
		UndoRedo undoRedo = new UndoRedo();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("MENU - SISTEMA DE FOLHA DE PAGAMENTO\n");
		System.out.println("ESCOLHA UMA OPÇÃO:\n\t1.ADICIONAR EMPREGADO\n\t2.REMOVER EMPREGADO\n\t3.LANÇAR CARTÃO DE PONTO\n\t4.LANÇAR RESULTADO DE VENDA");
		System.out.println("\t5.LANÇAR UMA TAXA DE SERVIÇO\n\t6.ALTERAR DETALHES DE UM EMPREGADO\n\t7.RODAR FOLHA DE PAGAMENTO PARA HOJE");
		System.out.println("\t8.VOLTAR UMA OPERAÇÃO REALIZADA\n\t9.MUDAR AGENDA DE PAGAMENTO DO EMPREGADO\n\t10.CRIAR NOVA AGENDA DE PAGAMENTO\n\t11.SAIR");
		
		int opcao = input.nextInt();
		while(opcao != 11) {
			undoRedo.getStackUndo().push(empresa);
			switch(opcao){
			case 1:
				if(cadastrarEmpregado(empresa)) {
					System.out.println("Empregado adicionado com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel adicionar este empregado!");
				
				break;
			case 2:
				if(removerEmpregado(empresa)) {
					System.out.println("Empregado removido com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel remover este empregado!");
				break;
			case 3:
				if(lancarCartao(empresa)) {
					System.out.println("Cartão de ponto lançado com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel lançar esse cartão de ponto para este empregado!");
				break;
			case 4:
				if(lancarVenda(empresa)) {
					System.out.println("O resultado da venda foi lançado com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel lançar esse resultado de venda!");
				break;
			case 5:
				if(lancarTaxaServico(empresa)) {
					System.out.println("Taxa de Serviço foi lançada com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel adicionar esta taxa de serviço");
				break;
			case 6:
				if(alterarEmpregado(empresa)) {
					System.out.println("Empregado alterado com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel alterar este empregado!");
				break;
			case 7:
				folhaPagamento(empresa);
				undoRedo.getStackRedo().clear();
				break;
			case 8:
				System.out.println("Deseja voltar uma operação?\n\t1.UNDO\n\t2.REDO");
				int opcaoUndoRedo = input.nextInt();
				if(opcaoUndoRedo == 1 && undoRedo.getStackUndo().size() != 0) {
					undoRedo.getStackRedo().push(empresa);
					empresa = undoRedo.getStackUndo().peek();
				}
				
				if(opcaoUndoRedo == 2 && undoRedo.getStackRedo().size() != 0) {
					undoRedo.getStackUndo().push(empresa);
					empresa = undoRedo.getStackRedo().peek();
				}
				break;
			case 9:
				if(mudarAgendaPagamento(empresa)){
					System.out.println("A agenda de pagamento do empregado foi alterada com sucesso!");
					undoRedo.getStackRedo().clear();
				}else
					System.out.println("Não foi possivel alterar a agenda de pagamento!");
				break;
			case 10:
				if(criarAgendaPagamento(empresa)) {
					System.out.println("Agenda criada com sucesso!");
					undoRedo.getStackRedo().clear();
				}else {
					System.out.println("Não foi possivel criar essa agenda de pagamento!");
				}
				break;
			default:
				System.out.println("Esta não é uma opção válida!");
				break;
			}
			
			System.out.println("MENU - SISTEMA DE FOLHA DE PAGAMENTO\n");
			System.out.println("ESCOLHA UMA OPÇÃO:\n\t1.ADICIONAR EMPREGADO\n\t2.REMOVER EMPREGADO\n\t3.LANÇAR CARTÃO DE PONTO\n\t4.LANÇAR RESULTADO DE VENDA");
			System.out.println("\t5.LANÇAR UMA TAXA DE SERVIÇO\n\t6.ALTERAR DETALHES DE UM EMPREGADO\n\t7.RODAR FOLHA DE PAGAMENTO PARA HOJE");
			System.out.println("\t8.VOLTAR UMA OPERAÇÃO REALIZADA\n\t9.MUDAR AGENDA DE PAGAMENTO DO EMPREGADO\n\t10.CRIAR NOVA AGENDA DE PAGAMENTO\n\t11.SAIR");
			
			opcao = input.nextInt();
		}
		
	}
}
