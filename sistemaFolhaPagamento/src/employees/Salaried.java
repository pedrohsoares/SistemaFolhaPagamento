package employees;

import java.util.Calendar;

import models.PaymentMethod;

public class Salaried extends Employee{
	private Double salary;
	
	public Salaried(Integer id, String name, String adress, PaymentMethod paymentMethod, Double salary) {
		super(id, name, adress, paymentMethod);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public void payroll() {
		Calendar currentDate = Calendar.getInstance();
		Calendar lastDay = Calendar.getInstance();
		
		lastDay.set(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		currentDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(lastDay.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
			lastDay.set(Calendar.DAY_OF_MONTH,lastDay.get(Calendar.DAY_OF_MONTH) - 1);
		
		if(lastDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			lastDay.set(Calendar.DAY_OF_MONTH,lastDay.get(Calendar.DAY_OF_MONTH) - 2);
		
		if(currentDate.get(Calendar.DAY_OF_MONTH) == lastDay.get(Calendar.DAY_OF_MONTH)) {
			this.setLastPayment(salary);
			this.setLastPaymentDate(Calendar.getInstance());
		}
	}

}
