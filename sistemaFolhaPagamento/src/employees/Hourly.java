package employees;

import java.util.ArrayList;
import java.util.Calendar;

import models.PaymentMethod;
import models.TimeCard;

public class Hourly extends Employee{
	private ArrayList<TimeCard> listTimeCard;
	private Double salaryHour;
	
	public Hourly(Integer id, String name, String adress, PaymentMethod paymentMethod, Double salaryHour) {
		super(id, name, adress, paymentMethod);
		this.listTimeCard = new ArrayList<TimeCard>();
		this.salaryHour = salaryHour;
	}

	public ArrayList<TimeCard> getListTimeCard() {
		return listTimeCard;
	}

	public void setListTimeCard(ArrayList<TimeCard> listTimeCard) {
		this.listTimeCard = listTimeCard;
	}
	
	public Double getSalaryHour() {
		return salaryHour;
	}

	public void setSalaryHour(Double salaryHour) {
		this.salaryHour = salaryHour;
	}
	
	public void addTimeCard(Calendar startDate, Calendar endDate){
		TimeCard newTimeCard = new TimeCard(startDate, endDate);
		this.listTimeCard.add(newTimeCard);
	}

	@Override
	public void payroll() {
		Calendar currentDate = Calendar.getInstance();
		Double totalSalary = 0.0;
		
		if(currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			for(TimeCard timeCard : this.listTimeCard) {
				Integer hour = timeCard.getEndDate().get(Calendar.HOUR_OF_DAY) - timeCard.getStartDate().get(Calendar.HOUR_OF_DAY);
				if(hour > 8) {
					totalSalary += (hour-8) * (this.salaryHour*1.5);
					totalSalary += 8 * this.salaryHour;
				}else {
					totalSalary += hour * this.salaryHour;
				}
			}
			
			this.listTimeCard.clear();
			this.setLastPayment(totalSalary);
			this.setLastPaymentDate(currentDate);
			
		}
	}
	
}
