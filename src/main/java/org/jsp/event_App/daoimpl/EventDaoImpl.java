package org.jsp.event_App.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.event_App.dao.EventDao;
import org.jsp.event_App.entity.Event;
import org.jsp.event_App.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component  (generic annotation)
@Repository  	// this a class will talks to the db (it is the one which will be having repository code)  
public class EventDaoImpl implements EventDao
{
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Event saveEvent(Event event) 
	{
		return eventRepository.save(event);
	}

	@Override
	public Event updateEvent(Event event) 
	{
		return eventRepository.save(event);
	}

	@Override
	public Optional<Event> findEventById(int id) 
	{
		return eventRepository.findById(id);
	}

	@Override
	public List<Event> findAllEvent() 
	{
		return eventRepository.findAll();
	}

	@Override
	public List<Event> findAllUpcomingEvent() 
	{
		return eventRepository.findAllUpcomingEvent();
	}

	@Override
	public List<Event> findAllOngoingEvent() 
	{
		return eventRepository.findAllOngoingEvent();
	}

	@Override
	public List<Event> findAllComletedEvent() 
	{
		return eventRepository.findAllComletedEvent();
	}

	@Override
	public List<Event> findAllDeletedEvent() 
	{
		return eventRepository.findAllDeletedEvent();
	}
	

}
