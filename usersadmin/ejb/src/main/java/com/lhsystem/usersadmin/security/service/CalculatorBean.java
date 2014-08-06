package com.lhsystem.usersadmin.security.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful
@Local(Calculator.class)
@StatefulTimeout(unit=TimeUnit.MINUTES,value=10)
public class CalculatorBean implements Calculator {

	private long value;
	
	@PreDestroy
	public void preDestroy()
	{
		System.out.println("calculator predestroy.");
	}
	
	@PrePassivate
	public void prePassivate()
	{
		System.out.println("calculator passivate");
	}
	
	@PostActivate
	public void postActivate()
	{
		System.out.println("calculator activate");
	}
	
	@PostConstruct
	public void postConstructor()
	{
		System.out.println("calculator constructed");
		
	}
	
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
