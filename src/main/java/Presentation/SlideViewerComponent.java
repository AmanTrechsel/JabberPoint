package main.java.Presentation;

import main.java.Accessor.SlideViewerFrame;
import main.java.Slide.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class SlideViewerComponent extends JComponent implements PresentationListener
{
	// Constants
	private static final long serialVersionUID = 227L;

	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	// Fields
	private Slide slide;
	private Font labelFont;
	private JFrame frame;

	// Presentatie variabelen
	private int slideNumber;
	private int presentationSize;

	// Constructor
	public SlideViewerComponent(JFrame frame)
	{
		this.setBackground(BGCOLOR);
		this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = frame;
	}

	// Constructor (Zonder JFrame)
	public SlideViewerComponent()
	{
		this.setBackground(BGCOLOR);
		this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = SlideViewerFrame.getInstance();
	}

	// Getter voor presentationSize
	public int getPresentationSize()
	{
		return this.presentationSize;
	}

	// Getter voor slide
	public Slide getSlide()
	{
		return slide;
	}

	// Geeft de preferred size
	public Dimension getPreferredSize()
	{
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	// Receiver voor wanneer de presentatie wordt geupdate
	@Override
	public void update(Presentation presentation, Slide slide)
	{
		// Als de slide null is, repaint
		if (slide == null)
		{
			this.slide = null;
			this.repaint();
			return;
		}

		// Update de slide en de slide nummer
		this.slide = slide;
		this.slideNumber = presentation.getSlideNumber();
		this.presentationSize = presentation.getSize();

		// Repaint en set de title
		this.repaint();
		this.frame.setTitle(presentation.getTitle());
	}

	// Tekent de slide
	public void paintComponent(Graphics graphics)
	{
		// Teken de achtergrond
		graphics.setColor(BGCOLOR);

		// Zet de achtergrond kleur, font en tekst kleur
		graphics.fillRect(0, 0, getSize().width, getSize().height);
		graphics.setFont(this.labelFont);
		graphics.setColor(COLOR);

		// Als de slide nummer kleiner is dan 0 of de slide null is, return
		if (this.slideNumber < 0 || this.slide == null)
		{
			return;
		}

		// Geeft de slide nummer weer
		graphics.drawString("Slide " + (1 + this.slideNumber) + " of " + this.presentationSize, XPOS, YPOS);

		// Bepaal de area en teken de slide
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(graphics, area, this);
	}
}

