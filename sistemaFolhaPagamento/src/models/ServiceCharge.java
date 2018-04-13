package models;

public class ServiceCharge {
	private String description;
	private double value;
	
	public ServiceCharge(String description, double value) {
		this.description = description;
		this.value = value;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	

}
