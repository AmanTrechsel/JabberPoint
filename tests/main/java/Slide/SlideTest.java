package main.java.Slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest
{
	private Slide slide;

	@BeforeEach
	void setup()
	{
		this.slide = new Slide();
	}

	@Test
	void slide_setTitle_toTest_expectsTest()
	{
		assertDoesNotThrow(() -> this.slide.setTitle("Test"));
		assertEquals("Test", this.slide.getTitle());
	}

	@Test
	void slide_append_oneItem_expectsSizeToBe1()
	{
		TextItem textItem = new TextItem(0, "Test");
		assertEquals(0, this.slide.getSize());
		assertEquals(new Vector<>(), this.slide.getSlideItems());
		assertDoesNotThrow(() -> this.slide.append(textItem));
		assertEquals(1, this.slide.getSize());
		assertEquals(textItem, this.slide.getSlideItem(0));
	}

	@Test
	void bitmapItem_getName_withNonExistentImage_expectsNotFoundImageName()
	{
		BitmapItem bitmapItem = new BitmapItem(0, "NotARealImage");
		assertEquals(BitmapItem.NOT_FOUND_IMAGE_NAME, bitmapItem.getName());
	}

	@Test
	void bitmapItem_getName_withNotFoundImagePath_expectsNotFoundImagePath()
	{
		BitmapItem bitmapItem = new BitmapItem(0, BitmapItem.NOT_FOUND_IMAGE_PATH);
		assertEquals(BitmapItem.NOT_FOUND_IMAGE_PATH, bitmapItem.getName());
	}

	@Test
	void textItem_getText_withNull_expectsEmptyString()
	{
		TextItem textItem = new TextItem(0, null);
		assertEquals("", textItem.getText());
	}

	@Test
	void textItem_getText_withText_expectsText()
	{
		TextItem textItem = new TextItem(0, "Text");
		assertEquals("Text", textItem.getText());
	}
}