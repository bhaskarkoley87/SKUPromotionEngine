package com.bhk.eng.rules;

import java.util.ArrayList;
import java.util.List;

import com.bhk.eng.beans.OrderDetails;

/*
 * This promotion rule will apply in the order list contains the 2 B's with value 45
 */
public class BBPromotion extends PromotionCalculator {

	@Override
	public OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception {
		char[] orderList = orderDetails.getOrderList();
		int total = orderDetails.getTotal();
		List<Integer> prsdElmnt = new ArrayList<Integer>();

		for (int x = 0; x < orderList.length; x++) {
			if (orderList[x] == 'B' || orderList[x] == 'b')
				prsdElmnt.add(x);
		}
		int orderSizeA = prsdElmnt.size();
		if (orderSizeA >= 2) {
			for (int y = 0; ((orderSizeA - y) / 2) >= 1;) {
				total += 45;
				orderList[prsdElmnt.get(y)] = '.';
				orderList[prsdElmnt.get(y + 1)] = '.';
				y += 2;
			}
			orderDetails.setOrderList(orderList);
			orderDetails.setTotal(total);
		}

		return orderDetails;
	}

}
