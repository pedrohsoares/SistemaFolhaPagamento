package employees;

import java.util.Calendar;

import models.PaymentMethod;


public abstract class Employee {
	private Integer id;
	private String name;
	private String adress;
	private Double lastPayment;
	private Calendar lastPaymentDate;
	private PaymentMethod paymentMethod;
	
	public Employee(Integer id, String name, String adress, PaymentMethod paymentMethod) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.lastPayment = 0.0;
		this.lastPaymentDate = null;
		this.paymentMethod = paymentMethod;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Double getLastPayment() {
		return lastPayment;
	}
	public void setLastPayment(Double lastPayment) {
		this.lastPayment = lastPayment;
	}
	public Calendar getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(Calendar lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void payroll() {
		
	}
	
}
