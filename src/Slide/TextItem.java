package Slide;

import Jabberpoint.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.ArrayList;

public class TextItem extends SlideItem
{
	// Standaard tekst als er geen tekst is
	private static final String EMPTYTEXT = "No Text Given";

	// Bevat de tekst van het item
	private String text;

	// Contructor
	public TextItem(int level, String text)
	{
		super(level);
		this.text = text;
	}

	// Constructor (Zonder level en tekst)
	public TextItem()
	{
		this(0, EMPTYTEXT);
	}

	// Getter voor de tekst
	public String getText()
	{
		return this.text == null ? "" : this.text;
	}

	// Geeft de AttributedString van de tekst
	public AttributedString getAttributedString(Style style, float scale)
	{
		AttributedString attributedString = new AttributedString(this.getText());
		attributedString.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, this.getText().length());
		return attributedString;
	}

	// Geeft de bounding box
	@Override
	public Rectangle getBoundingBox(Graphics graphics, ImageObserver imageObserver, float scale, Style style)
	{
		// Als er geen tekst is, geef een lege rechthoek terug
		if (this.text == null || this.text.length() == 0)
		{
			return new Rectangle(0, 0, 0, 0);
		}

		// Maak een lijst van layouts
		List<TextLayout> layouts = this.getLayouts(graphics, style, scale);

		// Bereken de grootte van de bounding box
		int xSize = 0, ySize = (int) (style.getLeading() * scale);

		// Loop door de layouts en bereken de grootte
		for (TextLayout layout : layouts)
		{
			// Haal de bounds van de layout op
			Rectangle2D bounds = layout.getBounds();

			// Als de breedte groter is dan xSize, zet xSize op de breedte
			if (bounds.getWidth() > xSize)
			{
				xSize = (int) bounds.getWidth();
			}

			// Als de hoogte groter is dan 0, voeg de hoogte toe aan ySize
			if (bounds.getHeight() > 0)
			{
				ySize += bounds.getHeight();
			}

			// Voeg de leading en descent toe aan de ySize
			ySize += layout.getLeading() + layout.getDescent();
		}

		// Geef de bounding box terug
		return new Rectangle((int) (style.getIndent() * scale), 0, xSize, ySize);
	}

	// Tekent het item
	@Override
	public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver)
	{
		// Als er geen tekst is, doe niets
		if (this.text == null || this.text.length() == 0)
		{
			return;
		}

		// Maak een lijst van layouts
		List<TextLayout> layouts = this.getLayouts(graphics, style, scale);

		// Maak een pen aan
		Point pen = new Point(x + (int) (style.getIndent() * scale), y + (int) (style.getLeading() * scale));

		// Maak een Graphics2D object aan
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(style.getColor());

		// Loop door de layouts en teken ze
		for (TextLayout layout : layouts)
		{
			// Teken de layout
			pen.y += layout.getAscent();
			layout.draw(graphics2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
	}

	// Haalt de layouts op
	private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale)
	{
		// Maak een lijst van layouts
		List<TextLayout> layouts = new ArrayList<TextLayout>();

		// Maak een AttributedString aan
		AttributedString attributedString = this.getAttributedString(style, scale);

		// Maak een Graphics2D object aan
		Graphics2D graphics2d = (Graphics2D) graphics;

		// Maak een FontRenderContext aan
		FontRenderContext fontRenderer = graphics2d.getFontRenderContext();

		// Maak een LineBreakMeasurer aan
		LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderer);

		// Bereken de wrapping width
		float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;

		// Loop door de tekst en voeg de layouts toe
		while (lineBreakMeasurer.getPosition() < this.getText().length())
		{
			TextLayout layout = lineBreakMeasurer.nextLayout(wrappingWidth);
			layouts.add(layout);
		}

		// Geef de layouts terug
		return layouts;
	}

	// Converteert het object naar een string
	@Override
	public String toString()
	{
		return "TextItem[" + this.getLevel() + "," + this.getText() + "]";
	}
}

