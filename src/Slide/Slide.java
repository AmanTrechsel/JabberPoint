package Slide;

import Jabberpoint.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title; // de titel wordt apart bewaard
    protected Vector<SlideItem> items; // de slide-items worden in een Vector bewaard

    public Slide() {
        items = new Vector<SlideItem>();
    }

    // Voeg een SlideItem toe
    public void append(SlideItem anItem) {
        items.addElement(anItem);
    }

    // geef de titel van de slide
    public String getTitle() {
        return title;
    }

    // verander de titel van de slide
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // Maak een TextItem van String, en voeg het TextItem toe
    public void append(int level, String message) {
        append(new TextItem(level, message));
    }

    // geef het betreffende SlideItem
    public SlideItem getSlideItem(int number) {
        return (SlideItem)items.elementAt(number);
    }

    // geef alle SlideItems in een Vector
    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    // geef de afmeting van de Slide
    public int getSize() {
        return items.size();
    }

    // teken de slide
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        // De titel wordt apart behandeld
        SlideItem slideItem = new TextItem(0, getTitle());
        Style style = Style.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number=0; number<getSize(); number++) {
            slideItem = (SlideItem)getSlideItems().elementAt(number);
            style = Style.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // geef de schaal om de slide te kunnen tekenen
    private float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
    }
}

