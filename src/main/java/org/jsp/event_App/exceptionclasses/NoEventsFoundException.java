package org.jsp.event_App.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoEventsFoundException extends RuntimeException
{
	private String message;

	public NoEventsFoundException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
