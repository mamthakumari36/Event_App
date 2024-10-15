package org.jsp.event_App.responsestructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ResponseStructure <T>
{
	private int status;
	private String message;
	private T body;

}
