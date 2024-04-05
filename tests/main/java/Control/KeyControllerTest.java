package main.java.Control;

import main.java.Jabberpoint.JabberPoint;
import main.java.Presentation.ControlPresentation;
import main.java.Presentation.Presentation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;

public class KeyControllerTest
{

	private ControlPresentation controlPresentation;
	private Presentation presentation;
	private KeyController keyController;
	private Component dummyComponent;

	@BeforeEach
	public void setup() throws IOException
	{
		this.keyController = KeyController.getInstance();
		this.dummyComponent = new JFrame();
		JabberPoint.initialize(new String[0]);
		this.controlPresentation = ControlPresentation.getInstance();
		this.presentation = this.controlPresentation.getPresentation();
	}

	@ParameterizedTest
	@ValueSource(ints = {KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, '+'})
	void keyController_nextPage(int keyCode)
	{
		assertEquals(0, this.presentation.getSlideNumber());
		this.keyController.keyPressed(new KeyEvent(this.dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
		assertEquals(1, this.presentation.getSlideNumber());
	}

	@ParameterizedTest
	@ValueSource(ints = {KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, '-'})
	void keyController_prevPage(int keyCode)
	{
		this.presentation.setSlideNumber(1);
		assertEquals(1, this.presentation.getSlideNumber());
		this.keyController.keyPressed(new KeyEvent(this.dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
		assertEquals(0, this.presentation.getSlideNumber());
	}
}
