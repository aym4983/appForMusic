package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.form.EventForm;
import fr.imie.appformusic.service.IEventService;

@RunWith(EasyMockRunner.class)
public class EventControllerTest {

	@Mock(type=MockType.NICE)
	private IEventService service;
	
	@TestSubject
	private EventController controller = new EventController();
	
	@Test
	public void testShowCalendar() throws Exception {
		BindingAwareModelMap model = new BindingAwareModelMap();
		
		//ModelAndView mav = controller.showCalendar(model);
		//assertThat(mav.getViewName()).isEqualTo("calendar");
		//assertThat(model.containsKey("eventForm")).isTrue();
	}

	@Test
	public void testSubmitEventForm() throws Exception {
		EventForm form = new EventForm();
		form.setTitleevent("test");
		form.setStartevent("01/02/2016");
		form.setEndevent("02/02/2016");
		
		Event ev = new Event();
		
		service.create(ev);
		EasyMock.expectLastCall();
		EasyMock.replay(service);
		
		controller.submitEventForm(form);
	}

}
