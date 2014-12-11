package io.crowdcode.scrumr.rest.calculator;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/calculator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculatorResource
{
	
	@POST
	public Response calculate(CalculatorRequest request)
	{
		if ("+".equals(request.getOperator()))
		{
			final long result = request.getValueA()+request.getValueB();
			final CalculatorResponse calculatorResult = new CalculatorResponse(result);
			return Response.ok(calculatorResult).build();
		} 
		return Response.status(Status.BAD_REQUEST).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response calculate(@FormParam("A") Long valueA, @FormParam("B") Long valueB) 
	{
		return Response.ok("<h1>"+(valueA+valueB)+"</h1>").build();
	}

}
