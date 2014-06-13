package com.lhsystems.usersadmin.security.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lhsystem.usersadmin.security.service.CalculatorBean;

public class CalculatorBeanTest {

	private CalculatorBean calculator = new CalculatorBean();
	
	@Test
	public void testAdd() {
		calculator.add(12l);
		assertEquals(12l, calculator.sum());
	}

	@Test
	public void testMultiAdd() {
		calculator.add(12l);
		calculator.add(12l);
		assertEquals(24l, calculator.sum());
	}
	
	@Test
	public void testMultiSub() {
		calculator.sub(12l);
		calculator.sub(12l);
		assertEquals(-24l, calculator.sum());
	}

	@Test
	public void testSub() {
		calculator.sub(12l);
		assertEquals(-12l, calculator.sum());
	}
	
	@Test
	public void testSubAndAdd() {
		calculator.sub(12l);
		calculator.add(12l);
		assertEquals(0l, calculator.sum());
	}
	
}
