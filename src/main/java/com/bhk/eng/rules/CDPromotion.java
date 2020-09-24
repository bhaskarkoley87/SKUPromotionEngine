package com.bhk.eng.rules;

import java.util.ArrayDeque;
import java.util.Deque;

import com.bhk.eng.beans.OrderDetails;

/*
 * This promotion rule will apply in the order list contains combination of C+D  with value 30
 */
public class CDPromotion extends PromotionCalculator {

	@Override
	public OrderDetails calculationOrder(OrderDetails orderDetails) throws Exception {
		char[] orderList = orderDetails.getOrderList();
		int total = orderDetails.getTotal();
		Deque<OrderElement> brkQueqe = new ArrayDeque<OrderElement>();

		for (int x = 0; x < orderList.length; x++) {
			if (orderList[x] == 'D' || orderList[x] == 'd' || orderList[x] == 'C' || orderList[x] == 'c') {
				if (!brkQueqe.isEmpty()) {
					OrderElement ele = brkQueqe.peek();
					if (!ele.getItem().equalsIgnoreCase(String.valueOf(orderList[x]))) {
						brkQueqe.pop();
						orderList[ele.getIndex()] = '.';
						orderList[x] = '.';
						total += 30;
					} else {
						brkQueqe.add(new OrderElement(String.valueOf(orderList[x]), x));
					}
				} else {
					brkQueqe.add(new OrderElement(String.valueOf(orderList[x]), x));
				}
			}

		}

		orderDetails.setOrderList(orderList);
		orderDetails.setTotal(total);

		return orderDetails;
	}

	private class OrderElement {
		String item;
		int index;

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public OrderElement(String item, int index) {

			this.item = item;
			this.index = index;
		}

	}

}
