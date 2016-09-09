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
	
}
