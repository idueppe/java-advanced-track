package io.crowdcode.scrumr.test;

import io.crowdcode.scrumr.model.Identifiable;
import io.crowdcode.scrumr.service.UserServiceTest.InjectIdAnswer;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestUtils
{
	
	public static InjectIdAnswer with(String expectedId)
	{
		return new InjectIdAnswer(expectedId);
	}
	
	public static class InjectIdAnswer implements Answer<Identifiable> {

		private String id;
		
		public InjectIdAnswer(String id) {
			this.id = id;
		}

		@Override
		public Identifiable answer(InvocationOnMock invocation) throws Throwable
		{
			for (Object object : invocation.getArguments()) 
			{
				if (object instanceof Identifiable)
				{
					((Identifiable)object).setId(id);
				}
			}
			
			return null;
		}
		
	}
	
}
