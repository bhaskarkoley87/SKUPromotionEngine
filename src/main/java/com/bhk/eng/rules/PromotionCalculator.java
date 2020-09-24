package com.bhk.eng.rules;

import com.bhk.eng.beans.OrderDetails;

public abstract class PromotionCalculator implements Calculator {

	protected PromotionCalculator nextCalculator;

	public abstract OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception;
	
	public void setNextCalculator(PromotionCalculator nextCalculator) {
		this.nextCalculator = nextCalculator;
	}

	public OrderDetails getOrderValue(OrderDetails orderDetails) throws Exception {
		
		orderDetails = calculationOrder(orderDetails);
		
		if(this.nextCalculator != null) {
			orderDetails = this.nextCalculator.getOrderValue(orderDetails);
		}
		return orderDetails;
	}

}
