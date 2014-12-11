package io.crowdcode.scrumr.rest.calculator;

public class CalculatorResponse
{
	private Long result;
	
	public CalculatorResponse() {}

	public CalculatorResponse(Long result)
	{
		this.result = result;
	}

	public Long getResult()
	{
		return result;
	}

	public void setResult(Long result)
	{
		this.result = result;
	}
	
}
