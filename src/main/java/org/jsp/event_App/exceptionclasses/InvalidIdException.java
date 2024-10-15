package org.jsp.event_App.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidIdException extends RuntimeException
{
	private String message;

	public InvalidIdException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
