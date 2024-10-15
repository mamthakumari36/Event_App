package org.jsp.event_App.exceptionhandling;

import org.jsp.event_App.exceptionclasses.InvalidIdException;
import org.jsp.event_App.exceptionclasses.NoEventsFoundException;
import org.jsp.event_App.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(NoEventsFoundException.class)
	public ResponseEntity<?> noEventsFoundExceptionHandler(NoEventsFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("Id not Found").body(e.getMessage()).build());
	}

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<?> invalidIdExceptionHandler(InvalidIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Id not Found").body(e.getMessage()).build());
	}
}
