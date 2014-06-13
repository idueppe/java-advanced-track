package com.lhsystem.usersadmin.security.service;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Local(Calculator.class)
public class CalculatorBean implements Calculator {

	private long value;
	
	@Override
	public void add(long value) {
		this.value += value;
	}

	@Override
	public void sub(long value) {
		this.value -= value;
	}

	@Override
	public long sum() {
		return value;
	}

	@Override
	@Remove
	public void off() {
		System.out.println("closing calculator service");
	}

}
