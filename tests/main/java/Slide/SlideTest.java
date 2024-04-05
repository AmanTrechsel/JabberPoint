package main.java.Slide;

import main.java.Jabberpoint.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest
{
	private Slide slide;

	@BeforeEach
	public void setup()
	{
		this.slide = new Slide();
	}

	@Test
	public void slide_setTitle_toTest_expectsTest()
	{
		assertDoesNotThrow(() -> this.slide.setTitle("Test"));
		assertEquals("Test", this.slide.getTitle());
	}

	@Test
	public void slide_append_oneItem_expectsSizeToBe1()
	{
		TextItem textItem = new TextItem(0, "Test");
		assertEquals(0, this.slide.getSize());
		assertEquals(new Vector<>(), this.slide.getSlideItems());
		assertDoesNotThrow(() -> this.slide.append(textItem));
		assertEquals(1, this.slide.getSize());
		assertEquals(textItem, this.slide.getSlideItem(0));
	}

	@Test
	public void bitmapItem_getName_withNonExistentImage_expectsNotFoundImageName()
	{
		BitmapItem bitmapItem = new BitmapItem(0, "NotARealImage");
		assertEquals(BitmapItem.NOT_FOUND_IMAGE_NAME, bitmapItem.getName());
	}

	@Test
	public void bitmapItem_getName_withNotFoundImagePath_expectsNotFoundImagePath()
	{
		BitmapItem bitmapItem = new BitmapItem(0, BitmapItem.NOT_FOUND_IMAGE_PATH);
		assertEquals(BitmapItem.NOT_FOUND_IMAGE_PATH, bitmapItem.getName());
	}

	@Test
	public void bitMapItem_ValidImage_expectPass()
	{
		BitmapItem bitmapItem = new BitmapItem(1, "src/main/resources/images/demo1.jpg");
		assertNotNull(bitmapItem);
		assertEquals(1, bitmapItem.getLevel());
		assertEquals("src/main/resources/images/demo1.jpg", bitmapItem.getName());
	}

	@Test
	public void bitMapItem_invalidImage_expectNotFound()
	{
		BitmapItem bitmapItem = new BitmapItem(1, "src/main/resources/images/invalidImage.jpg");
		assertNotNull(bitmapItem);
		assertEquals(1, bitmapItem.getLevel());
		assertEquals("not-found", bitmapItem.getName());
	}

	@Test
	public void bitMapItem_validImageBoundingBix_expectCorrectValues()
	{
		Style style = new Style(0, Color.black, 12, 10);
		Style.createStyles();

		BitmapItem bitmapItem = new BitmapItem(1, "src/main/resources/images/demo1.jpg");
		Rectangle boundingBox = bitmapItem.getBoundingBox(null, null, 1.0f, style);

		assertNotEquals(null, boundingBox);
		assertEquals(0, boundingBox.getX());
		assertEquals(0, boundingBox.getY());
		// Values for demo1.jpg
		assertEquals(275.0, boundingBox.getWidth());
		assertEquals(193.0, boundingBox.getHeight());
	}

	@Test
	public void textItem_getText_withNull_expectsEmptyString()
	{
		TextItem textItem = new TextItem(0, null);
		assertEquals("", textItem.getText());
	}

	@Test
	public void textItem_getText_withText_expectsText()
	{
		TextItem textItem = new TextItem(0, "Text");
		assertEquals("Text", textItem.getText());
	}
}