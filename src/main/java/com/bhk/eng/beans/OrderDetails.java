package com.bhk.eng.beans;

public class OrderDetails {
	private char[] orderList;
	private int total;	
	
	
	public OrderDetails(char[] orderList, int total) {		
		this.orderList = orderList;
		this.total = total;
	}

	public char[] getOrderList() {
		return orderList;
	}

	public void setOrderList(char[] orderList) {
		this.orderList = orderList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
