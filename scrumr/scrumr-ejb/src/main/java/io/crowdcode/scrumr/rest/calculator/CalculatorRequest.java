package io.crowdcode.scrumr.rest.calculator;

public class CalculatorRequest
{
	private Long valueA;
	private Long valueB;
	private String operator;

	public Long getValueA()
	{
		return valueA;
	}

	public void setValueA(Long valueA)
	{
		this.valueA = valueA;
	}

	public Long getValueB()
	{
		return valueB;
	}

	public void setValueB(Long valueB)
	{
		this.valueB = valueB;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

}
