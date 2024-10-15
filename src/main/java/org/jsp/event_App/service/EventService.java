package org.jsp.event_App.service;

import java.time.LocalDateTime;

import org.jsp.event_App.entity.Event;
import org.springframework.http.ResponseEntity;

public interface EventService {

	ResponseEntity<?> saveEvent(Event event);

	ResponseEntity<?> findEventById(int id);

	ResponseEntity<?> findAllEvent();

	ResponseEntity<?> findAllUpcomingEvent();

	ResponseEntity<?> findAllComletedEvent();

	ResponseEntity<?> findAllOngoingEvent();

	ResponseEntity<?> findAllDeletedEvent();

	ResponseEntity<?> setEventStatusToOngoing(int id);

	ResponseEntity<?> setEventStatusToCompleted(int id);

	ResponseEntity<?> setEventStatusToDeleted(int id);

	ResponseEntity<?> findEventBetweenDate(LocalDateTime fromDateTime, LocalDateTime toDateTime);

}
