package org.jsp.event_App.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.event_App.entity.Event;

public interface EventDao 
{
	Event saveEvent(Event event);
	
	Event updateEvent(Event event);
	
	Optional<Event> findEventById(int id);
	
	List<Event> findAllEvent();
	
	List<Event> findAllUpcomingEvent();
	
	List<Event> findAllOngoingEvent();
	
	List<Event> findAllComletedEvent();
	
	List<Event> findAllDeletedEvent();
	
//	Event setEventStatusToOngoing(int id);
}
