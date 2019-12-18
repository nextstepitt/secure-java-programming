// CalculatorTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wonderfulwidgets.calculator.Calculator;

public class CalculatorTests {
	
	private Calculator calculator;
	
	@Before
	public void setup() {

		calculator = new Calculator();
	}

	@Test
	public void Adds1And1() {
		
		assertEquals(2, calculator.add(1, 1), 0.0001);
	}

	@Test
	public void Adds0And0() {
		
		assertEquals(0, calculator.add(0, 0), 0.0001);
	}
	
	@Test
	public void Adds9999And9999() {
		
		assertEquals(19998, calculator.add(9999, 9999), 0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAddNegative1AndNegative1() {
		
		calculator.add(-1, -1);
		// assertThrows(IllegalArgumentException.class, () -> calculator.add(-1, -1) );
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAdd10000And10000() {
		
		calculator.add(10000, 10000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAddNegative1And10000() {
		
		calculator.add(-1, 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAdd10000AndNegative1() {
		
		calculator.add(10000, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAddNegative1And1() {
		
		calculator.add(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAdd1AndNegative1() {
		
		calculator.add(1, -1);
	}	

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAdd10000And9999() {
		
		calculator.add(10000, 9999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void DoesNotAdd9999And10000() {
		
		calculator.add(9999, 10000);
	}
	
	@Test
	public void Subtracts0From0() {
		
		assertEquals(0, calculator.subtract(0, 0), 0.0001);
	}
	
	@Test
	public void Subtracts1From1() {
		
		assertEquals(0, calculator.subtract(1, 1), 0.0001);
	}
}
