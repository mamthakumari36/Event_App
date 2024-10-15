package org.jsp.event_App.repository;

import java.util.List;

import org.jsp.event_App.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer>
{
	@Query("select e from Event e where e.status = 'UP_COMING'")
	List<Event> findAllUpcomingEvent();

	@Query("select e from Event e where e.status = 'ON_GOING'")
	List<Event> findAllOngoingEvent();

	@Query("select e from Event e where e.status = 'COMPLETED'")
	List<Event> findAllComletedEvent();

	@Query("select e from Event e where e.status = 'DELETED'")
	List<Event> findAllDeletedEvent();

}
