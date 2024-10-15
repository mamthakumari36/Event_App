package org.jsp.event_App.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.event.util.EventStatus;
import org.jsp.event_App.dao.EventDao;
import org.jsp.event_App.entity.Event;
import org.jsp.event_App.exceptionclasses.InvalidIdException;
import org.jsp.event_App.exceptionclasses.NoEventsFoundException;
import org.jsp.event_App.responsestructure.ResponseStructure;
import org.jsp.event_App.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDao eventDao;

	@Override
	public ResponseEntity<?> saveEvent(Event event) {
		event.setStatus(EventStatus.UP_COMING);
		Event dbEvent = eventDao.saveEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Saved Successfully").body(dbEvent).build());
	}

	@Override
	public ResponseEntity<?> findEventById(int id) {
		Optional<Event> optional = eventDao.findEventById(id);
		if (optional.isEmpty())
			throw InvalidIdException.builder().message("Given id is invalid").build();

		Event e = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event found Successfully").body(e).build());
	}

	@Override
	public ResponseEntity<?> findAllEvent() {
		List<Event> events = eventDao.findAllEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No Events found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Event found Successfully").body(events).build());
	}

	@Override
	public ResponseEntity<?> findAllUpcomingEvent() {
		List<Event> events = eventDao.findAllUpcomingEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No UP_COMING Events found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All UP_COMING Events Successfully").body(events).build());
	}

	@Override
	public ResponseEntity<?> findAllComletedEvent() {
		List<Event> events = eventDao.findAllComletedEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No COMPLETED Events found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All COMPLETED Events Successfully").body(events).build());
	}

	@Override
	public ResponseEntity<?> findAllOngoingEvent() {
		List<Event> events = eventDao.findAllOngoingEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No ONGOING Events found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All ONGOING Events Successfully").body(events).build());
	}

	@Override
	public ResponseEntity<?> findAllDeletedEvent() {
		List<Event> events = eventDao.findAllDeletedEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No DELETED Events found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All DELETED Events Successfully").body(events).build());
	}

	@Override
	public ResponseEntity<?> setEventStatusToOngoing(int id) {
		Optional<Event> event = eventDao.findEventById(id);
		if (event.isEmpty())
			throw InvalidIdException.builder().message("Invalid Event id").build();
		Event e = event.get();
		e.setStatus(EventStatus.ON_GOING);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Status Set To ON_GOING").body(eventDao.updateEvent(e)).build());
	}

	@Override
	public ResponseEntity<?> setEventStatusToCompleted(int id) {
		Optional<Event> event = eventDao.findEventById(id);
		if (event.isEmpty())
			throw InvalidIdException.builder().message("Invalid Event id").build();
		Event e = event.get();
		e.setStatus(EventStatus.COMPLETED);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Status Set To COMPLETED").body(eventDao.updateEvent(e)).build());
	}

	@Override
	public ResponseEntity<?> setEventStatusToDeleted(int id) {
		Optional<Event> event = eventDao.findEventById(id);
		if (event.isEmpty())
			throw InvalidIdException.builder().message("Invalid Event id").build();
		Event e = event.get();
		e.setStatus(EventStatus.DELETED);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Status Set To DELETED").body(eventDao.updateEvent(e)).build());
	}

	@Override
	public ResponseEntity<?> findEventBetweenDate(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
		List<Event> events = eventDao.findAllComletedEvent();
		if (events.isEmpty())
			throw NoEventsFoundException.builder().message("No Events found").build();

		ArrayList<Event> eventInRange = new ArrayList<>();
		for (Event e : events) {
			if (e.getFromDateTime().isAfter(fromDateTime) && e.getToDateTime().isBefore(toDateTime)) {
				eventInRange.add(e);
			}
		}
		if (eventInRange.isEmpty())
			throw NoEventsFoundException.builder().message("No Events Found In The Given Range").build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found events in the given range").body(eventInRange).build());

	}

}
