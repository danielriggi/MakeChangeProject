package makechange;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the price of the item?");
		String[] nameArr = { "twenty dollar bill", "ten dollar bill", "five dollar bill", "one dollar bill", "quarter",
				"dime", "nickle", "penny" };
		double[] valueArr = { 20, 10, 5, 1, .25, .1, .05, .01 };
		int[] resArr = { 0, 0, 0, 0, 0, 0, 0, 0 };

		double price = keyboard.nextDouble();
		System.out.println("What is the amount tendered by the customer?");
		double tendered = keyboard.nextDouble();
		double remainder = tendered - price;
		//due to rounding errors
		remainder = Math.round(remainder * 100.0) / 100.0;
        int idx;
		if (tendered < price) {
			System.out.println("Not enough money provided!");
			System.exit(0);
		} else {
			idx = 0;
			for (double coin : valueArr) {
				resArr[idx] += remainder / coin;
				remainder = remainder % coin;
				//due to rounding errors
				remainder = Math.round(remainder * 100.0) / 100.0;
				idx++;
			}
		}
		
		//result string formatting
		idx = 0;
		String resString = "";
		for (int i : resArr) {
			if (i > 0) {
				if (i == 1) {
					resString += "1 " + nameArr[idx] + ", ";
				} else {
					if (!nameArr[idx].equals("penny")) {
						resString += i + " " + nameArr[idx] + "s, ";
					}
					else {
						resString += i + " pennies.";			
					}
				}
			}
			idx++;
		}
		
		if (resString.endsWith(".")) {
			System.out.println(resString);
		}
		else {
			System.out.println(resString.substring(0, resString.length() - 2) + ".");
		}
	}
}
