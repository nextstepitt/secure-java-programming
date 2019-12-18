// Calculator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.calculator;

class Calculator {
	
	// Numbers must be between 0 and 9999

	double add(double x, double y) {
		
		double result = 0;
		
		if (x >= 0 && x <= 9999 && y >= 0 && y <= 9999) {
		
			result = x + y;
		
		} else {
		
			throw new IllegalArgumentException();
		}
		
		return result;
	}
	
	double subtract(double x, double y) {
		
		return 0;
	}
}
