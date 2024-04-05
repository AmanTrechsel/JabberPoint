package Accessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Presentation.Presentation;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorTest
{
	private Presentation presentation;

	@BeforeEach
	public void setup() throws IOException
	{
		this.presentation = new Presentation();
	}

	@Test
	void xmlAccessor_loadFile_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> new XMLAccessor().loadFile(this.presentation, "test.xml"));
		assertEquals("Test", this.presentation.getTitle());
	}

	@Test
	void xmlAccessor_loadFile_expectToNotLoad() throws IOException
	{
		new XMLAccessor().loadFile(this.presentation, "notAnActualFile.xml");
		assertEquals("", this.presentation.getTitle());
	}
}