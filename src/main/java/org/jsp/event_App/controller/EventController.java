package org.jsp.event_App.controller;

import java.time.LocalDateTime;

import org.jsp.event_App.entity.Event;
import org.jsp.event_App.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/events")
public class EventController {
	@Autowired
	private EventService eventService;

//	ResponseEntity = to match network status and our status
	
	@Operation(summary = "To Save The Event", description = "This Api Will Accept An Event Json Object and Saves it to the db table and Return the saved event entity Object")
	@ApiResponses(value = {@ApiResponse(responseCode = "200" , description = "Event Saved Successfully")})
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findEventById(@PathVariable int id) {
		return eventService.findEventById(id);
	}

	@Operation(summary="To Fetch All events",description="This api will fetch all the events available in the db table")
	@ApiResponses(value={@ApiResponse(responseCode="200",description="All the Events Found Successfully..."),@ApiResponse(responseCode="404",description = "No Events Present in the db table")})
	@GetMapping
	public ResponseEntity<?> findAllEvent() {
		return eventService.findAllEvent();
	}

	@GetMapping("/upcoming")
	public ResponseEntity<?> findAllUpcomingEvent() {
		return eventService.findAllUpcomingEvent();
	}

	@GetMapping("/ongoing")
	public ResponseEntity<?> findAllOngoingEvent() {
		return eventService.findAllOngoingEvent();
	}

	@GetMapping("/completed")
	public ResponseEntity<?> findAllComletedEvent() {
		return eventService.findAllComletedEvent();
	}

	@Hidden
	@GetMapping("/deleted")
	public ResponseEntity<?> findAllDeletedEvent() {
		return eventService.findAllDeletedEvent();
	}

	@Hidden
	@Operation(summary = "Set Event Status To ON_GOING",description = "This api will set the event status to ON_GOING based on event id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Event Set to ON_GOING"),@ApiResponse(responseCode = "400",description = "Invalid Id, Unable to Set Status to ON_GOING")})
	@PatchMapping("/ongoing/{id}")
	public ResponseEntity<?> setEventStatusToOngoing(@PathVariable int id) {
		return eventService.setEventStatusToOngoing(id);
	}

	@Hidden
	@Operation(summary = "Set Event Status To COMPLETED",description = "This api will set the event status to COMPLETED based on event id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Event Set to COMPLETED"),@ApiResponse(responseCode = "400",description = "Invalid Id, Unable to Set Status to COMPLETED")})
	@PatchMapping("/completed/{id}")
	public ResponseEntity<?> setEventStatusToCompleted(@PathVariable int id) {
		return eventService.setEventStatusToCompleted(id);
	}

	@Operation(summary = "Set Event Status To DELETED",description = "This api will set the event status to DELETED based on event id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Event Set to DELETED"),@ApiResponse(responseCode = "400",description = "Invalid Id, Unable to Set Status to DELETED")})
	@PatchMapping("/deleted/{id}")
	public ResponseEntity<?> setEventStatusToDeleted(@PathVariable int id) {
		return eventService.setEventStatusToDeleted(id);
	}

	@GetMapping("/in-date")
	public ResponseEntity<?> findEventBetweenDate(@RequestParam LocalDateTime fromDateTime,
			@RequestParam LocalDateTime toDateTime) {
		return eventService.findEventBetweenDate(fromDateTime, toDateTime);
	}
}
