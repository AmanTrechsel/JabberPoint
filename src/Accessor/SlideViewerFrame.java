package Accessor;

import Presentation.*;
import Control.*;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

public class SlideViewerFrame extends JFrame
{
  // Constants
	private static final long serialVersionUID = 3227L;

	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

  // Singleton
	private static SlideViewerFrame slideViewerFrame;
	public static SlideViewerFrame getInstance()
	{
		if (SlideViewerFrame.slideViewerFrame == null)
    {
			SlideViewerFrame.slideViewerFrame = new SlideViewerFrame(JABTITLE);
		}

		return SlideViewerFrame.slideViewerFrame;
	}

  // Constructor
	public SlideViewerFrame(String title)
	{
		super(title);

    // De SlideViewerComponent aanmaken
		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(this);
		ControlPresentation.getInstance().setShowView(slideViewerComponent);

    // De GUI opzetten
		this.setupWindow(slideViewerComponent);
	}

	// De GUI opzetten
	public void setupWindow(SlideViewerComponent slideViewerComponent)
	{
    // Zet de titel
		setTitle(JABTITLE);

    // Voeg een WindowListener toe om de applicatie te sluiten
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

    // Voeg de SlideViewerComponent toe aan de content pane
		getContentPane().add(slideViewerComponent);

    // Voeg de KeyController en MenuController toe
		addKeyListener(KeyController.getInstance());
		setMenuBar(MenuController.getInstance());

    // Zet de grootte en zichtbaarheid
		setSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
	}
}

