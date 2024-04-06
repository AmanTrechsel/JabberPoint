package main.java.Slide;

import main.java.Jabberpoint.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class SlideItem
{
	// Level van het item
	private final int level;

	// Constructor
	public SlideItem(int level)
	{
		this.level = level;
	}

	// Constructor (Zonder level)
	public SlideItem()
	{
		this(0);
	}

	// Getter voor het level
	public int getLevel()
	{
		return this.level;
	}

	// Geeft de bounding box
	public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver imageObserver, float scale, Style style);

	// Tekent het item
	public abstract void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver);
}
