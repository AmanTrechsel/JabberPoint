package Slide;

import Jabberpoint.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;


public abstract class SlideItem
{
    private int level = 0; // het level van het slideitem

    public SlideItem(int lev)
    {
        level = lev;
    }

    public SlideItem()
    {
        this(0);
    }

    // Geef het level
    public int getLevel()
    {
        return level;
    }

    // Geef de bounding box
    public abstract Rectangle getBoundingBox(Graphics g,
                                             ImageObserver observer, float scale, Style style);

    // teken het item
    public abstract void draw(int x, int y, float scale,
                              Graphics g, Style style, ImageObserver observer);
}
