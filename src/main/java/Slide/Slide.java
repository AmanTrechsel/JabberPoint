package main.java.Slide;

import main.java.Jabberpoint.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide
{
	// Constants
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

	// Fields
	protected String title;
	protected Vector<SlideItem> items;

	// Constructor
	public Slide()
	{
		this.items = new Vector<SlideItem>();
	}

	// Getter voor de SlideItems
	public Vector<SlideItem> getSlideItems()
	{
		return this.items;
	}

	// Getter voor de titel
	public String getTitle()
	{
		return this.title;
	}

	// Setter voor de titel
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}

	// Voegt een SlideItem toe
	public void append(SlideItem anItem)
	{
		this.items.addElement(anItem);
	}

	// Maakt een TextItem van String, en voeg het TextItem toe
	public void append(int level, String text)
	{
		this.append(new TextItem(level, text));
	}

	// Geeft de SlideItem op de gegeven index
	public SlideItem getSlideItem(int index)
	{
		return (SlideItem) this.items.elementAt(index);
	}

	// Geeft het aantal SlideItems
	public int getSize()
	{
		return this.items.size();
	}

	// Tekent de slide in het gegeven gebied
	public void draw(Graphics graphics, Rectangle area, ImageObserver imageObserver)
	{
		// Initiële variabelen
		float scale = this.getScale(area);
		int y = area.y;

		// De titel wordt apart behandeld
		SlideItem slideItem = new TextItem(0, getTitle());
		Style style = Style.getStyle(slideItem.getLevel());

		// Tekenen van de titel
		slideItem.draw(area.x, y, scale, graphics, style, imageObserver);

		// Verhoog de y-coördinaat
		y += slideItem.getBoundingBox(graphics, imageObserver, scale, style).height;

		// Tekenen van de SlideItems
		for (int number = 0; number < getSize(); number++)
		{
			// Haal het SlideItem op
			slideItem = (SlideItem) getSlideItems().elementAt(number);

			// Bepaal de stijl van het SlideItem
			style = Style.getStyle(slideItem.getLevel());

			// Tekenen van het SlideItem
			slideItem.draw(area.x, y, scale, graphics, style, imageObserver);

			// Verhoog de y-coördinaat
			y += slideItem.getBoundingBox(graphics, imageObserver, scale, style).height;
		}
	}

	// Geeft het gebied dat de slide nodig heeft
	private float getScale(Rectangle area)
	{
		return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
	}
}

