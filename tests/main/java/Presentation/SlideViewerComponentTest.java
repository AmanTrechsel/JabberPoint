package main.java.Presentation;

import main.java.Jabberpoint.JabberPoint;
import main.java.Slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SlideViewerComponentTest
{
	private SlideViewerComponent slideViewerComponent;

	@BeforeEach
	void setup() throws IOException
	{
		JabberPoint.initialize(new String[0]);
		this.slideViewerComponent = new SlideViewerComponent();
	}

	@Test
	void update_withControlPresentation_expectsPresentationToBeControlPresentation()
	{
		Presentation controlPresentation = ControlPresentation.getInstance().getPresentation();
		Slide newSlide = new Slide();
		assertNotEquals(controlPresentation.getSize(), this.slideViewerComponent.getPresentationSize());
		assertDoesNotThrow(() -> this.slideViewerComponent.update(controlPresentation, newSlide));
		assertEquals(controlPresentation.getSize(), this.slideViewerComponent.getPresentationSize());
	}

	@Test
	void update_withoutSlide_expectsSlideToBeNull()
	{
		assertDoesNotThrow(() -> this.slideViewerComponent.update(new Presentation(), null));
		assertNull(this.slideViewerComponent.getSlide());
	}
}