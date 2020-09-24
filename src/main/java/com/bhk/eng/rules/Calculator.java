package com.bhk.eng.rules;

import com.bhk.eng.beans.OrderDetails;

public interface Calculator {
	 public OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception;  
}
