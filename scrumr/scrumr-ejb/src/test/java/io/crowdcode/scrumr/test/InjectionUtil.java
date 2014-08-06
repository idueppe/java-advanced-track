package io.crowdcode.scrumr.test;

import java.lang.reflect.Field;

public class InjectionUtil
{
	private Object toBeInjected;

	protected InjectionUtil(Object toBeInjected)
	{
		this.toBeInjected = toBeInjected;
	}

	public static InjectionUtil inject(Object toBeInjected)
	{
		return new InjectionUtil(toBeInjected);
	}

	public InjectionUtil into(Object target)
	{
		final Class<? extends Object> clazz = toBeInjected.getClass();

		for (Field field : target.getClass().getDeclaredFields())
		{
			if (field.getType().isAssignableFrom(clazz))
			{
				boolean accessible = field.isAccessible();
				try
				{
					field.setAccessible(true);
					field.set(target, toBeInjected);
				} catch (IllegalArgumentException | IllegalAccessException e)
				{
					throw new RuntimeException("Couldn't inject.", e);
				} finally
				{
					field.setAccessible(accessible);
				}
			}
		}

		return this;
	}

}
