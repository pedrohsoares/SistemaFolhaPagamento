package main;

import employees.Employee;
import models.UndoRedo;


public class Main {
	
	public static void main(String[] args) {
		Company company = new Company("UFAL");
		UndoRedo undoRedo = new UndoRedo();
		Menu menu = new Menu();
		
		Integer option = menu.mainMenu();
		while(option != 9) {
			undoRedo.getStackUndo().push(company);
			switch(option) {
				case 1:
					if(menu.addEmployee(company)) {
						System.out.println("Empregado adicionado com sucesso!");
					}else {
						System.out.println("Nao foi possivel adicionar este empregado!");
					}
					break;
				case 2:
					menu.removeEmployee(company);
					break;
				case 3:
					menu.addTimeCard(company);
					break;
				case 4:
					menu.addSaleResult(company);
					break;
				case 5:
					menu.addServiceCharge(company);
					break;
				case 6:
					menu.updateEmployee(company);
					break;
				case 7:
					for(Employee employee : company.getListEmployee())
						employee.payroll();
					break;
				case 8:
					menu.undoRedo(undoRedo, company);
					break;
			}
			
			option = menu.mainMenu();
		}
		System.out.println("Sistema encerrado!");
	}
}
