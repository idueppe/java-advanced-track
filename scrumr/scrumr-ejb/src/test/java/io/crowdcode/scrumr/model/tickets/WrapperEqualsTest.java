package io.crowdcode.scrumr.model.tickets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WrapperEqualsTest
{
	@Test
	public void testName() throws Exception
	{
		Long einsA = 1L; // Long einsA = Long.valueOf(1L) und new Long(1L)
		Long einsB = 1L;
		Long zweihundertA = 200L; // Long zweihundert = Long.valueOf(200L); // new Long(200L)
		Long zweihundertB = 200L;
		
		// so nicht sondern einsA.equals(einsB) oder ObjectUtils.equals(einsA,einsB);
		assertTrue(einsA == 1L); // => assertTrue(einsA.longValue() == 1l)
		assertTrue(einsA == einsB); 
		assertTrue(zweihundertA == 200L); // => assertTrue(zweihundertA.longValue() == 200l)
		assertFalse(zweihundertA == zweihundertB); 
	
	}
}
