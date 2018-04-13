package main;

import java.util.Calendar;
import java.util.Scanner;

import employees.Commissioned;
import employees.CommissionedSyndicated;
import employees.Employee;
import employees.Hourly;
import employees.HourlySyndicated;
import employees.Salaried;
import employees.SalariedSyndicated;
import models.PaymentMethod;
import models.UndoRedo;

public class Menu {
	public int mainMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("MENU - SISTEMA DE FOLHA DE PAGAMENTO\n");
		System.out.println("ESCOLHA UMA OPCAO:");
		System.out.println("\t1.ADICIONAR EMPREGADO\n\t2.REMOVER EMPREGADO\n\t3.LANCAR CARTAO DE PONTO");
		System.out.println("\t4.LANCAR RESULTADO DE VENDA\n\t5.LANCAR UMA TAXA DE SERVICO\n\t6.ALTERAR DETALHES DE UM EMPREGADO");
		System.out.println("\t7.RODAR FOLHA DE PAGAMENTO PARA HOJE\n\t8.VOLTAR UMA OPERACAO REALIZADA");
		System.out.println("\t9.SAIR");
		
		System.out.println("Informe uma opcao:");
		Integer option = Integer.parseInt(input.nextLine());
		
		while(option < 1 || option > 9) {
			System.out.println("Opcao invalida, digite novamente:");
			option = Integer.parseInt(input.nextLine());
		}
		
		return option;
	}
	
	public boolean addEmployee(Company company){
		Scanner input = new Scanner(System.in);
		PaymentMethod paymentMethod;
		
		System.out.println("\tCADASTRO DE NOVO EMPREGADO");
		System.out.println("Informe o nome do empregado:");
		String name = input.nextLine();
		
		System.out.println("Informe o endereco do empregado:");
		String adress = input.nextLine();
		
		
		System.out.println("Escolha o metodo de pagamento: \n\t1.CHEQUE PELOS CORREIOS\n\t2.CHEQUE EM MAOS\n\t3.DEPOSITO BANCARIO");
		Integer option = Integer.parseInt(input.nextLine());
		
		while(option < 1 || option > 3) {
			System.out.println("Opcao invalida, digite novamente:");
			option = Integer.parseInt(input.nextLine());
		}
		
		switch(option){
			case 1:
				paymentMethod = PaymentMethod.CHEQUE_CORREIOS;
				break;
			case 2:
				paymentMethod = PaymentMethod.CHEQUE_MAOS;
				break;
			case 3:
				paymentMethod = PaymentMethod.DEPOSITO_BANCARIO;
				break;
			default:
				paymentMethod = PaymentMethod.DEPOSITO_BANCARIO;
		}
		
		System.out.println("O empregado e sindicalizado? \n\t1.SIM\n\t2.NAO");
		option = Integer.parseInt(input.nextLine());
		
		while(option < 1 || option > 2) {
			System.out.println("Opcao invalida, digite novamente:");
			option = Integer.parseInt(input.nextLine());
		}
		
		System.out.println("Escolha o tipo de empregado: \n\t1.HORISTA\n\t2.ASSALARIADO\n\t3.COMISSIONADO");
		int employeeOption = Integer.parseInt(input.nextLine());
		
		while(employeeOption < 1 || employeeOption > 3) {
			System.out.println("Opcao invalida, digite novamente:");
			employeeOption = Integer.parseInt(input.nextLine());
		}
		
		Integer id;
		if(company.getListEmployee().size() > 0) {
			id = company.getListEmployee().get(company.getListEmployee().size()-1).getId() + 1;
		}else {
			id = 0;
		}
		
		switch(employeeOption){
			case 1:
				System.out.println("Informe a taxa normal de hora trabalhada:");
				Double salaryHour = Double.parseDouble(input.nextLine());
				if(option == 1) {
					HourlySyndicated hourlySyndicated = new HourlySyndicated(id, name, adress, paymentMethod, salaryHour);
					return company.addEmployee(hourlySyndicated);
				}else {
					Hourly hourly = new Hourly(id, name, adress, paymentMethod, salaryHour);
					return company.addEmployee(hourly);
				}
			case 2:
				System.out.println("Informe o salario fixo:");
				Double salary = Double.parseDouble(input.nextLine());
				if(option == 1) {
					SalariedSyndicated salariedSyndicated = new SalariedSyndicated(id, name, adress, paymentMethod, salary);
					return company.addEmployee(salariedSyndicated);
				}else {
					Salaried salaried = new Salaried(id, name, adress, paymentMethod, salary);
					return company.addEmployee(salaried);
				}
				
			case 3:
				System.out.println("Informe a taxa de comissao:");
				Double commission = Double.parseDouble(input.nextLine());
				if(option == 1) {
					CommissionedSyndicated commissionedSyndicated = new CommissionedSyndicated(id, name, adress, paymentMethod, commission);
					return company.addEmployee(commissionedSyndicated);
				}else {
					Commissioned commissioned = new Commissioned(id, name, adress, paymentMethod, commission);
					return company.addEmployee(commissioned);
				}
		}
		
		return false;
	}
	
	public void removeEmployee(Company company){
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o codigo do empregado que deseja remover: ");
		Integer employeeId = Integer.parseInt(input.nextLine());
		
		if(company.removeEmployee(employeeId)) {
			System.out.println("Empregado removido com sucesso!");
		}else {
			System.out.println("Nao foi possivel remover este empregado");
		}
	}
	
	public void addTimeCard(Company company){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o codigo do empregado:");
		Integer id = Integer.parseInt(input.nextLine());
		
		Employee employee = company.getEmployeeById(id);
		
		if(employee != null) {
			if(employee.getClass() == Hourly.class || employee.getClass() == HourlySyndicated.class) {
				System.out.println("Informe a hora de chegada:");
				Integer startHour = Integer.parseInt(input.nextLine());
				
				System.out.println("Informe o minuto de chegada:");
				Integer startMinute = Integer.parseInt(input.nextLine());
				
				Calendar startDate = Calendar.getInstance();
				startDate.set(Calendar.HOUR_OF_DAY, startHour);
				startDate.set(Calendar.MINUTE,startMinute);
				
				System.out.println("Informe a hora de saida:");
				Integer endHour = Integer.parseInt(input.nextLine());
				
				System.out.println("Informe o minuto de saida:");
				Integer endMinute = Integer.parseInt(input.nextLine());
				
				Calendar endDate = Calendar.getInstance();
				endDate.set(Calendar.HOUR_OF_DAY, endHour);
				endDate.set(Calendar.MINUTE,endMinute);
				
				Hourly hourly = (Hourly) employee;
				hourly.addTimeCard(startDate, endDate);
			}else {
				System.out.println("Este empregado nao e horista");
			}
		}else {
			System.out.println("Nao foi encontrado nenhum empregado com este codigo");
		}
	}
	
	public void addSaleResult(Company company) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o código do empregado:");
		Integer id = Integer.parseInt(input.nextLine());
		
		Employee employee = company.getEmployeeById(id);
		if(employee != null) {
			if(employee.getClass() == Commissioned.class || employee.getClass() == CommissionedSyndicated.class) {
				System.out.println("Informe o valor da venda");
				Double salePrice = Double.parseDouble(input.nextLine());
				
				System.out.println("Informe o data da venda no formato (dd/mm/aaaa):");
				String dateStr = input.nextLine();
				
				while(isValidDate(dateStr) == null) {
					System.out.println("Data no formato incorreto, digite novamente:");
					dateStr = input.nextLine();
				}
				
				Calendar saleDate = isValidDate(dateStr);
				
				Commissioned commissioned = (Commissioned) employee;
				
				commissioned.addSaleResult(saleDate, salePrice);
				System.out.println("Resultado de venda adicionado com sucesso!");
			}else {
				System.out.println("Este empregado nao e comissionado!");
			}
			
		}else {
			System.out.println("Nao foi encontrado nenhum empregado com esse codigo!");
		}
	}
	
	public void addServiceCharge(Company company) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o codigo do empregado:");
		Integer id = Integer.parseInt(input.nextLine());
		
		Employee employee = company.getEmployeeById(id);
		
		if(employee != null) {
			if(employee.getClass() == CommissionedSyndicated.class || employee.getClass() == HourlySyndicated.class ||
					employee.getClass() == SalariedSyndicated.class) {
				System.out.println("Informe a descricao da taxa de servico:");
				String description = input.nextLine();
				
				System.out.println("Informe o valor da taxa de servico:");
				Double value = Double.parseDouble(input.nextLine());
				
				if(employee.getClass() == SalariedSyndicated.class) {
					SalariedSyndicated salariedSyndicated = (SalariedSyndicated) employee;
					salariedSyndicated.addServiceCharge(description, value);
				}else if(employee.getClass() == HourlySyndicated.class) {
					HourlySyndicated hourlySyndicated = (HourlySyndicated) employee;
					hourlySyndicated.addServiceCharge(description, value);
				}else {
					CommissionedSyndicated commissionedSyndicated = (CommissionedSyndicated) employee;
					commissionedSyndicated.addServiceCharge(description, value);
				}
				
				System.out.println("Taxa de servico adicionada com sucesso!");
			}else {
				System.out.println("Este empregado nao e sindicalizado!");
			}
		}else {
			System.out.println("Nao foi encontrado nenhum empregado com esse codigo");
		}
	}
	
	public void updateEmployee(Company company) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o codigo do empregado:");
		Integer id = Integer.parseInt(input.nextLine());
		
		Employee employee = company.getEmployeeById(id);
		
		if(employee != null) {
			System.out.println("Informe o dado que você deseja alterar:\n\t1.Nome\n\t2.Endereco"
					+ "\n\t3.Metodo de Pagamento\n\t4.Sindicato");
			
			Integer option = Integer.parseInt(input.nextLine());
			
			switch(option) {
				case 1:
					System.out.println("Informe o novo nome desejado:");
					String name = input.nextLine();
					employee.setName(name);
					System.out.println("Nome alterado com sucesso!");
					break;
				case 2:
					System.out.println("Informe o novo endereco desejado:");
					String adress = input.nextLine();
					employee.setAdress(adress);
					System.out.println("Endereco alterado com sucesso!");
					break;
				case 3:
					System.out.println("Informe o novo metodo de pagamento:\n\t1.Cheque pelos Correios\n\t2.Cheque em maos\n\t3.Deposito Bancario");
					
					Integer paymentOption = Integer.parseInt(input.nextLine());
					
					while(paymentOption < 1 || paymentOption > 3) {
						System.out.println("Opcao invalida, digite novamente:");
						paymentOption = Integer.parseInt(input.nextLine());
					}
					
					switch(paymentOption) {
						case 1:
							employee.setPaymentMethod(PaymentMethod.CHEQUE_CORREIOS);
							break;
						case 2:
							employee.setPaymentMethod(PaymentMethod.CHEQUE_MAOS);
							break;
						case 3:
							employee.setPaymentMethod(PaymentMethod.DEPOSITO_BANCARIO);
							break;
					}
					
					System.out.println("Metodo de pagamento alterado com sucesso!");
			
					break;
				case 4:
					if(employee.getClass() == CommissionedSyndicated.class || employee.getClass() == HourlySyndicated.class ||
						employee.getClass() == SalariedSyndicated.class) {
						System.out.println("Deseja remover esse empregado do sindicato:\n\t1.Sim\n\t2.Nao");
						Integer syndicatedOption = Integer.parseInt(input.nextLine());
						
						if(syndicatedOption == 1) {
							if(employee.getClass() == HourlySyndicated.class) {
								Hourly hourly = (Hourly) employee;
								company.removeEmployee(id);
								company.addEmployee(hourly);
							}else if(employee.getClass() == SalariedSyndicated.class) {
								Salaried salaried = (Salaried) employee;
								company.removeEmployee(id);
								company.addEmployee(salaried);
							}else {
								Commissioned commissioned = (Commissioned) employee;
								company.removeEmployee(id);
								company.addEmployee(commissioned);
							}
							
							System.out.println("Empregado removido do sindicato com sucesso!");
						}
						
					}else {
						System.out.println("Deseja adicionar esse empregado no sindicato:\n\t1.Sim\n\t2.Nao");
						
						Integer syndicatedOption = Integer.parseInt(input.nextLine());
						
						if(syndicatedOption == 1) {
							if(employee.getClass() == Hourly.class) {
								HourlySyndicated hourlySyndicated = (HourlySyndicated) employee;
								company.removeEmployee(id);
								company.addEmployee(hourlySyndicated);
							}else if(employee.getClass() == Salaried.class) {
								SalariedSyndicated salariedSyndicated = (SalariedSyndicated) employee;
								company.removeEmployee(id);
								company.addEmployee(salariedSyndicated);
							}else {
								CommissionedSyndicated commissionedSyndicated = (CommissionedSyndicated) employee;
								company.removeEmployee(id);
								company.addEmployee(commissionedSyndicated);
							}
							
							System.out.println("Empregado adiciano ao sindicato com sucesso!");
						}
					}
					break;
				default:
					System.out.println("Esta nao e uma opção valida!");
					break;
			}
			
		}else {
			System.out.println("Empregado nao encontrado!");
		}
	}
	
	public void undoRedo(UndoRedo undoRedo,Company company) {
		Scanner input = new Scanner(System.in);
		System.out.println("Deseja voltar uma operação?\n\t1.UNDO\n\t2.REDO");
		Integer option = Integer.parseInt(input.nextLine());
		
		if(option == 1) {
			if(undoRedo.getStackUndo().size() != 0) {
				undoRedo.getStackRedo().push(company);
				company = undoRedo.getStackUndo().peek();
			}else {
				System.out.println("Nao possui nenhuma alteracao para ser revertida!");
			}
		}else if(option == 2) {
			if(undoRedo.getStackRedo().size() != 0) {
				undoRedo.getStackUndo().push(company);
				company = undoRedo.getStackRedo().peek();
			}else {
				System.out.println("Nao possui nenhuma alteracao para ser revertida!");
			}
		}else {
			System.out.println("Opcao invalida!");
		}
	}
	
	private Calendar isValidDate(String date) {
		//Data : 24/10/1996
		
		if(date.length() == 10) {
			if(date.charAt(2) == '/' && date.charAt(5) == '/') {
				Integer day = Integer.parseInt(date.substring(0, 2));
				Integer month = Integer.parseInt(date.substring(3, 5));
				Integer year = Integer.parseInt(date.substring(6));
				if(day <= 31 && month <= 12) {
					Calendar newDate = Calendar.getInstance();
					newDate.set(year, month, day);
					
					return newDate;
				}
			}
		}
			
		return null;
	}
}
