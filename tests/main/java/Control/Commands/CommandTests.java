package main.java.Control.Commands;

import main.java.Accessor.DemoPresentation;
import main.java.Accessor.ImageDemo;
import main.java.Accessor.PlenairDemo;
import main.java.Jabberpoint.JabberPoint;
import main.java.Presentation.ControlPresentation;
import main.java.Presentation.Presentation;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandTests
{
	private ControlPresentation controlPresentation;
	private Presentation presentation;
	private PageUp pageUp;
	private PageDown pageDown;
	private MenuDemoBase menuDemoBase;
	private MenuDemoImage menuDemoImage;
	private MenuDemoPlenair menuDemoPlenair;

	@BeforeEach
	public void setup() throws IOException
	{
		JabberPoint.initialize(new String[0]);
		this.controlPresentation = ControlPresentation.getInstance();
		this.presentation = this.controlPresentation.getPresentation();
		this.pageUp = new PageUp();
		this.pageDown = new PageDown();
		this.menuDemoBase = new MenuDemoBase();
		this.menuDemoImage = new MenuDemoImage();
		this.menuDemoPlenair = new MenuDemoPlenair();
	}

	@Test
	public void pageUp_execute_expectPass()
	{
		assertEquals(0, this.presentation.getSlideNumber());
		this.pageUp.execute();
		assertEquals(1, this.presentation.getSlideNumber());
	}

	@Test
	public void pageDown_execute_expectPass()
	{
		assertEquals(0, this.presentation.getSlideNumber());
		this.pageUp.execute();
		assertEquals(1, this.presentation.getSlideNumber());
		this.pageDown.execute();
		assertEquals(0, this.presentation.getSlideNumber());
	}

	@Test
	public void menuDemoBase_execute_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> this.menuDemoBase.execute());
		assertEquals("Demo Presentation", this.presentation.getTitle());
		assertEquals(4, this.presentation.getSize());
	}

	@Test
	public void menuDemoImage_execute_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> this.menuDemoImage.execute());
		assertEquals("Image Demo Presentation", this.presentation.getTitle());
		assertEquals(4, this.presentation.getSize());
	}

	@Test
	public void menuDemoPlenair_execute_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> this.menuDemoPlenair.execute());
		assertEquals("Plenary Meeting Demo", this.presentation.getTitle());
		assertEquals(7, this.presentation.getSize());
	}
}