package fr.imie.appformusic.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IEventDao;
import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.service.IEventService;

@RunWith(EasyMockRunner.class)
public class EventServiceTest {

	@TestSubject
	private IEventService service = new EventService();
	
	@Mock(type=MockType.NICE)
	private IEventDao daoMock;
	
	@Test
	public void testCreate() throws Exception {
		fr.imie.appformusic.domain.Event ev = new fr.imie.appformusic.domain.Event();
		
		daoMock.create(ev);
		expectLastCall();
		replay(daoMock);
		
		service.create(ev);
	}

	@Test
	public void testFindById() throws Exception {
		final int EVENT_ID = 1;
		fr.imie.appformusic.domain.Event ev = new fr.imie.appformusic.domain.Event();
		ev.setid(EVENT_ID);
		ev.setTitleevent("testEvent");
		
		expect(daoMock.findById(EVENT_ID)).andReturn(ev);
		replay(daoMock);
		
		fr.imie.appformusic.domain.Event result = service.findById(EVENT_ID);
		assertThat(result).isNotNull();
		assertThat(result.getTitleevent()).isEqualTo("testEvent");
	}

	@Test
	public void testFindAllEvents() throws Exception {
		List<Event> liste = new ArrayList<>();
		Event ev1 = new Event();
		Event ev2 = new Event();
		
		liste.add(ev1);
		liste.add(ev2);
		ev1.setTitleevent("e1");
		ev2.setTitleevent("e2");
		
		expect(daoMock.findAllEvents()).andReturn(liste);
		replay(daoMock);
		
		List<Event> result = service.findAllEvents();
		assertThat(result)
			.isNotNull()
			.isNotEmpty()
			.hasSameSizeAs(liste);
	}

	@Test
	public void testDeleteEvent() throws Exception {
		Event ev = new Event();
		
		daoMock.deleteEvent(ev);
		expectLastCall();
		
		service.deleteEvent(ev);
	}

}
