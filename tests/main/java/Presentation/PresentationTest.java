package main.java.Presentation;

import main.java.Jabberpoint.JabberPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest
{
	@BeforeEach
	void setup() throws IOException
	{
		JabberPoint.initialize(new String[0]);
	}

	@Test
	void getInstance_expectsNotNull()
	{
		assertNotNull(ControlPresentation.getInstance());
	}

	@Test
	void getPresentation_expectsNotNull()
	{
		assertNotNull(ControlPresentation.getInstance().getPresentation());
	}

	@Test
	void setPresentation_toNewPresentation_expectsToBeNewPresentation()
	{
		Presentation newPresentation = new Presentation();
		newPresentation.setTitle("Test");
		assertDoesNotThrow(() -> ControlPresentation.getInstance().setPresentation(newPresentation));
		assertEquals(newPresentation, ControlPresentation.getInstance().getPresentation());
		assertEquals(newPresentation.getTitle(), ControlPresentation.getInstance().getPresentation().getTitle());
	}

	@Test
	void prevSlide_from2_expectsToBe1()
	{
		assertDoesNotThrow(() -> ControlPresentation.getInstance().getPresentation().setSlideNumber(2));
		assertEquals(2, ControlPresentation.getInstance().getPresentation().getSlideNumber());
		assertDoesNotThrow(() -> ControlPresentation.getInstance().prevSlide());
		assertEquals(1, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void prevSlide_from0_expectsToBe0()
	{
		assertDoesNotThrow(() -> ControlPresentation.getInstance().getPresentation().setSlideNumber(0));
		assertEquals(0, ControlPresentation.getInstance().getPresentation().getSlideNumber());
		assertDoesNotThrow(() -> ControlPresentation.getInstance().prevSlide());
		assertEquals(0, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void nextSlide_from1_expectsToBe2()
	{
		assertDoesNotThrow(() -> ControlPresentation.getInstance().getPresentation().setSlideNumber(1));
		assertEquals(1, ControlPresentation.getInstance().getPresentation().getSlideNumber());
		assertDoesNotThrow(() -> ControlPresentation.getInstance().nextSlide());
		assertEquals(2, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void nextSlide_fromCapacity_expectsToBeCapacity()
	{
		int capacity = ControlPresentation.getInstance().getPresentation().getSize() - 1;
		assertDoesNotThrow(() -> ControlPresentation.getInstance().getPresentation().setSlideNumber(capacity));
		assertEquals(capacity, ControlPresentation.getInstance().getPresentation().getSlideNumber());
		assertDoesNotThrow(() -> ControlPresentation.getInstance().nextSlide());
		assertEquals(capacity, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void setSlideNumber_fromNegative_expectsToBe0()
	{
		assertDoesNotThrow(() -> ControlPresentation.getInstance().setSlideNumber(-1));
		assertEquals(0, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void setSlideNumber_from2_expectsToBe2()
	{
		assertDoesNotThrow(() -> ControlPresentation.getInstance().setSlideNumber(2));
		assertEquals(2, ControlPresentation.getInstance().getPresentation().getSlideNumber());
	}

	@Test
	void clear_expectsSizeToBe0()
	{
		assertEquals(4, ControlPresentation.getInstance().getPresentation().getSize());
		assertDoesNotThrow(() -> ControlPresentation.getInstance().clear());
		assertEquals(0, ControlPresentation.getInstance().getPresentation().getSize());
	}
}