package models;

import java.util.Calendar;

public class SaleResult {
	private Calendar saleDate;
	private Double salePrice;
	
	public SaleResult(Calendar saleDate, Double salePrice){
		this.saleDate = saleDate;
		this.salePrice = salePrice;
	}
	
	public Calendar getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}
