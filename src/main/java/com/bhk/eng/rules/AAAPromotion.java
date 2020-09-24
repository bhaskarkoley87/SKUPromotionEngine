package com.bhk.eng.rules;

import java.util.ArrayList;
import java.util.List;

import com.bhk.eng.beans.OrderDetails;

/*
 * This promotion rule will apply in the order list contains the 3 A's with value 130
 */
public class AAAPromotion extends PromotionCalculator {

	@Override
	public OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception {
		char[] orderList = orderDetails.getOrderList();
		int total = orderDetails.getTotal();
		List<Integer> prsdElmnt = new ArrayList<Integer>();

		for (int x = 0; x < orderList.length; x++) {
			if (orderList[x] == 'A' || orderList[x] == 'a')
				prsdElmnt.add(x);
		}
		int orderSizeA = prsdElmnt.size();
		if (orderSizeA >= 3) {
			for (int y = 0; ((orderSizeA - y) / 3) >= 1;) {
				total += 130;
				orderList[prsdElmnt.get(y)] = '.';
				orderList[prsdElmnt.get(y + 1)] = '.';
				orderList[prsdElmnt.get(y + 2)] = '.';
				y += 3;
			}
			orderDetails.setOrderList(orderList);
			orderDetails.setTotal(total);
		}

		return orderDetails;
	}

}
