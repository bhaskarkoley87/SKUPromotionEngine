package com.bhk.eng;

import com.bhk.eng.beans.OrderDetails;
import com.bhk.eng.rules.AAAPromotion;
import com.bhk.eng.rules.BBPromotion;
import com.bhk.eng.rules.CDPromotion;
import com.bhk.eng.rules.GeneralRatesCalculation;
import com.bhk.eng.rules.PromotionCalculator;

public class PromotionEngine {
	public int calculateOrderValue(char[] orderList) {
		OrderDetails orderDetails = new OrderDetails(orderList, 0);

		try {

			PromotionCalculator aaaPromotionCalculator = new AAAPromotion();

			PromotionCalculator bbPromotionCalculator = new BBPromotion();
			aaaPromotionCalculator.setNextCalculator(bbPromotionCalculator);

			PromotionCalculator cdPromotionCalculator = new CDPromotion();
			bbPromotionCalculator.setNextCalculator(cdPromotionCalculator);

			PromotionCalculator gPromotionCalculator = new GeneralRatesCalculation();
			cdPromotionCalculator.setNextCalculator(gPromotionCalculator);

			orderDetails = aaaPromotionCalculator.getOrderValue(orderDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails.getTotal();
	}
}
