package com.hussain.model;


public class Sale {
	private String billNo;
	private double amount;
	private String customerName;
	public Sale(String billNo, double amount, String customerName) {
		super();
		this.billNo = billNo;
		this.amount = amount;
		this.customerName = customerName;
	}
	public Sale() {
		super();
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public String toString() {
		return "Sale[billNo : "+billNo+", Amount : "+amount+", customerName : "+customerName+"]";
	}
	
	
	
}
