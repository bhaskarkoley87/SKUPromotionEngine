package com.bhk.eng;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;


@PrepareForTest(PromotionEngineTests.class)
public class PromotionEngineTests {
	
	private PromotionEngine promotionEngine;
	
	@Before
	public void setUp() {
		promotionEngine = new PromotionEngine();
	}
	
	@Test
	public void testOrderValue1() {
		char[] orderList = {'A', 'B', 'C'};
		int expectedResult = 100;
		long result = promotionEngine.calculateOrderValue(orderList);
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testOrderValue2() {
		char[] orderList = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'C'};
		int expectedResult = 370;
		long result = promotionEngine.calculateOrderValue(orderList);
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testOrderValue3() {
		char[] orderList = {'A', 'A', 'A', 'C', 'B', 'B', 'B', 'B', 'B', 'D'};
		int expectedResult = 280;
		long result = promotionEngine.calculateOrderValue(orderList);
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testOrderValue4() {
		char[] orderList = {'A', 'A', 'A', 'C', 'C', 'B', 'B', 'B', 'B', 'B', 'D', 'A'};
		int expectedResult = 350;
		long result = promotionEngine.calculateOrderValue(orderList);
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testOrderValue5() {
		char[] orderList = {'A', 'A', 'A', 'C', 'D', 'B', 'B', 'B', 'B', 'B', 'D', 'A'};
		int expectedResult = 345;
		long result = promotionEngine.calculateOrderValue(orderList);
		assertEquals(expectedResult, result);
	}

}
