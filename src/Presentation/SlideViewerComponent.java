package Presentation;

import Slide.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class SlideViewerComponent extends JComponent implements PresentationListener
{
	private Slide slide; // de huidige slide
	private Font labelFont = null; // het font voor labels
	private JFrame frame = null;
	private int slideNumber;
	private int presentationSize;

	private static final long serialVersionUID = 227L;

	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	public SlideViewerComponent(JFrame frame)
	{
		setBackground(BGCOLOR);
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = frame;
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(Presentation presentation, Slide data)
	{
		if (data == null)
		{
			repaint();
			return;
		}
		this.slide = data;
		this.slideNumber = presentation.getSlideNumber();
		this.presentationSize = presentation.getSize();
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	// teken de slide
	public void paintComponent(Graphics g)
	{
		g.setColor(BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (this.slideNumber < 0 || slide == null)
		{
			return;
		}
		g.setFont(labelFont);
		g.setColor(COLOR);
		g.drawString("Slide " + (1 + this.slideNumber) + " of " + this.presentationSize, XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(g, area, this);
	}
}

