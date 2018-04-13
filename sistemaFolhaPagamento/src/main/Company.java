package main;

import java.util.ArrayList;
import employees.Employee;

public class Company {
	private String name;
	private ArrayList<Employee> listEmployee;
	
	public Company(String name) {
		this.name = name;
		this.listEmployee = new ArrayList<Employee>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(ArrayList<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public boolean addEmployee(Employee employee){
		for(Employee currentEmployee : this.listEmployee) {
			if(currentEmployee.getName().equals(employee.getName()) && currentEmployee.getAdress().equals(employee.getAdress())) {
				return false;
			}
		}
		
		this.listEmployee.add(employee);
		return true;
	}
	
	public boolean removeEmployee(Integer employeeId){
		for(Employee employee : this.listEmployee){
			if(employee.getId() == employeeId){
				this.listEmployee.remove(employee);
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeById(Integer id) {
		for(Employee employee : this.listEmployee)
			if(employee.getId() == id)
				return employee;
		
		return null;
	}

}
