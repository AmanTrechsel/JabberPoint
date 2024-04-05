package main.java.Accessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Presentation.Presentation;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AccessorTest
{
	private Presentation presentation;

	@BeforeEach
	public void setup() throws IOException
	{
		this.presentation = new Presentation();
	}

	@Test
	public void demoPresentation_loadFile_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> new DemoPresentation().loadFile(this.presentation, ""));
		assertEquals("Demo Presentation", this.presentation.getTitle());
		assertEquals(4, this.presentation.getSize());
	}

	@Test
	public void imageDemo_loadFile_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> new ImageDemo().loadFile(this.presentation, ""));
		assertEquals("Image Demo Presentation", this.presentation.getTitle());
		assertEquals(4, this.presentation.getSize());
	}

	@Test
	public void plenairDemo_loadFile_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> new PlenairDemo().loadFile(this.presentation, ""));
		assertEquals("Plenair Demo Presentation", this.presentation.getTitle());
		assertEquals(2, this.presentation.getSize());
	}

	@Test
	public void xmlAccessor_loadFile_expectToLoad() throws IOException
	{
		assertDoesNotThrow(() -> new XMLAccessor().loadFile(this.presentation, "test.xml"));
		assertEquals("Test", this.presentation.getTitle());
	}

	@Test
	public void xmlAccessor_loadFile_expectToNotLoad() throws IOException
	{
		new XMLAccessor().loadFile(this.presentation, "notAnActualFile.xml");
		assertEquals("", this.presentation.getTitle());
	}
}