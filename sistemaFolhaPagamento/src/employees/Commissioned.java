package employees;

import java.util.ArrayList;
import java.util.Calendar;

import models.PaymentMethod;
import models.SaleResult;

public class Commissioned extends Employee {
	private ArrayList<SaleResult> listSaleResult;
	private Double commission;
	
	public Commissioned(Integer id, String name, String adress, PaymentMethod paymentMethod, Double commission) {
		super(id, name, adress, paymentMethod);
		this.listSaleResult = new ArrayList<SaleResult>();
		this.commission = commission;
	}

	public ArrayList<SaleResult> getListSaleResult() {
		return listSaleResult;
	}

	public void setListSaleResult(ArrayList<SaleResult> listSaleResult) {
		this.listSaleResult = listSaleResult;
	}
	
	public void addSaleResult(Calendar saleDate, double salePrice){
		SaleResult newSaleResult = new SaleResult(saleDate, salePrice);
		this.listSaleResult.add(newSaleResult);
	}
	
	@Override
	public void payroll() {
		Calendar currentDate = Calendar.getInstance();
		if((currentDate.get(Calendar.WEEK_OF_MONTH) == 1 || currentDate.get(Calendar.WEEK_OF_MONTH) == 3) && currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			Double salaryTotal = 0.0;
			
			for(SaleResult saleResult : this.listSaleResult)
				salaryTotal += (saleResult.getSalePrice() * this.commission);
			
			this.listSaleResult.clear();
			this.setLastPayment(salaryTotal);
			this.setLastPaymentDate(currentDate);
		}
	}
	
}
