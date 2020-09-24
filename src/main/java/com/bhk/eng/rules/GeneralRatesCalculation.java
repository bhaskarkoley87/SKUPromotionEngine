package com.bhk.eng.rules;

import com.bhk.eng.beans.OrderDetails;

/*
 * This promotion rule will apply in the order list for remaining items with default individual value 
 * A = 50
 * B = 30
 * C = 20
 * D = 15
 */
public class GeneralRatesCalculation extends PromotionCalculator {

	@Override
	public OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception {
		char[] orderList = orderDetails.getOrderList();
		int total = orderDetails.getTotal();

		for (int x = 0; x < orderList.length; x++) {
			switch (orderList[x]) {
			case 'A':
			case 'a':
				total += 50;
				break;
			case 'B':
			case 'b':
				total += 30;
				break;
			case 'C':
			case 'c':
				total += 20;
				break;
			case 'D':
			case 'd':
				total += 15;
				break;
			default:
				break;
			}
		}
		orderDetails.setTotal(total);

		return orderDetails;
	}

}
