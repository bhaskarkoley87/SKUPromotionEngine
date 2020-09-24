package com.bhk.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bhk.eng.PromotionEngine;

public class Application {

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(in);
		PromotionEngine poEngine = new PromotionEngine();
		System.out.println("Enter the Order elements seperated with one space :");
		try {
			String data = input.readLine();
			char[] orderElement = data.toCharArray();
			long result = poEngine.calculateOrderValue(orderElement);
			System.out.println("Total Order value : "+result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
