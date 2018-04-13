package employees;

import java.util.ArrayList;
import java.util.Calendar;

import models.PaymentMethod;
import models.ServiceCharge;

public class SalariedSyndicated extends Salaried{
	private ArrayList<ServiceCharge> listServiceCharge;

	public SalariedSyndicated(Integer id, String name, String adress, PaymentMethod paymentMethod, Double salary) {
		super(id, name, adress, paymentMethod, salary);
		this.listServiceCharge = new ArrayList<ServiceCharge>();
	}

	public ArrayList<ServiceCharge> getListServiceCharge() {
		return listServiceCharge;
	}

	public void setListServiceCharge(ArrayList<ServiceCharge> listServiceCharge) {
		this.listServiceCharge = listServiceCharge;
	}
	
	public void addServiceCharge(String description, double value){
		ServiceCharge newServiceCharge = new ServiceCharge(description, value);
		this.listServiceCharge.add(newServiceCharge);
	}
	
	@Override
	public void payroll() {
		super.payroll();
		Calendar currentDate = Calendar.getInstance();
		
		if(currentDate.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
			Double totalService = 0.0;
			for(ServiceCharge serviceCharge : this.listServiceCharge)
				totalService += serviceCharge.getValue();
			
			this.setLastPayment(this.getLastPayment() - totalService);
		}
	}
}
