package main.java.Slide;

import main.java.Jabberpoint.Style;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

public class BitmapItemTest {

    @Test
    public void bitMapItem_ValidImage_expactPass() {
        BitmapItem bitmapItem = new BitmapItem(1, "src/main/resources/images/demo1.jpg");
        assertNotNull(bitmapItem);
        assertEquals(1, bitmapItem.getLevel());
        assertEquals("src/main/resources/images/demo1.jpg", bitmapItem.getName());
    }

    @Test
    public void bitMapItem_invalidImage_expactNotFound() {
        BitmapItem bitmapItem = new BitmapItem(1, "src/main/recources/images/invalidImage.jpg");
        assertNotNull(bitmapItem);
        assertEquals(1, bitmapItem.getLevel());
        assertEquals("not-found", bitmapItem.getName());
    }

    @Test
    public void bitMapItem_validImageBoundingBix_expectCorrectValues() {
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

}