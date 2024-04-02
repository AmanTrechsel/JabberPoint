package Slide;

import Jabberpoint.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem
{
	// Constants
	protected static final String NOT_FOUND_IMAGE_PATH = "src/main/resources/images/not-found.jpg";
	protected static final String FILE = "Bestand ";
	protected static final String NOT_FOUND = " niet gevonden";

	// BufferedImage voor de afbeelding
	private BufferedImage bufferedImage;

	// Naam van de afbeelding
	private String imageName;

	// Constructor
	public BitmapItem(int level, String imageName)
	{
		super(level);
		this.imageName = imageName;

		// Probeer de afbeelding in te laden
		try
		{
			this.bufferedImage = ImageIO.read(new File(this.imageName));
		}
		catch (IOException exception)
		{
			System.out.println(FILE + this.imageName + NOT_FOUND);
			
			// Probeer de not found image te laden
			try
			{
				this.bufferedImage = ImageIO.read(new File(NOT_FOUND_IMAGE_PATH));
			}
			catch (IOException notFoundException)
			{
				System.err.println(FILE + this.imageName + NOT_FOUND);
			}
		}
	}

	// Constructor (Zonder level en naam)
	public BitmapItem()
	{
		this(0, null);
	}

	// Getter voor de naam
	public String getName()
	{
		return this.imageName;
	}

	// Geeft de bounding box
	@Override
	public Rectangle getBoundingBox(Graphics graphics, ImageObserver imageObserver, float scale, Style style)
	{
		return new Rectangle((int) (style.getIndent() * scale), 0, (int) (this.bufferedImage.getWidth(imageObserver) * scale), ((int) (style.getLeading() * scale)) + (int) (this.bufferedImage.getHeight(imageObserver) * scale));
	}

	// Tekent het item
	@Override
	public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver)
	{
		// Bereken de breedte en hoogte
		int width = x + (int) (style.getIndent() * scale);
		int height = y + (int) (style.getLeading() * scale);

		// Tekenen van de afbeelding
		graphics.drawImage(this.bufferedImage, width, height, (int) (this.bufferedImage.getWidth(imageObserver) * scale), (int) (this.bufferedImage.getHeight(imageObserver) * scale), imageObserver);
	}

	// Converteert het object naar een string
	@Override
	public String toString()
	{
		return "BitmapItem[" + this.getLevel() + "," + this.imageName + "]";
	}
}

