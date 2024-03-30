package Jabberpoint;

import Accessor.*;
import Presentation.*;

import javax.swing.JOptionPane;
import java.io.IOException;

public class JabberPoint
{
  // Constants
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	// Het hoofdprogramma
	public static void main(String argv[])
	{
    // Creëer de verschillende stijlen
		Style.createStyles();

    // Creëer de presentatie
		Presentation presentation = new Presentation();

    // Haal de ControlPresentation op en zet de presentatie erin
		ControlPresentation controlPresentation = ControlPresentation.getInstance();
		controlPresentation.setPresentation(presentation);

    // Maak de SlideViewerFrame zichtbaar
    SlideViewerFrame.getInstance().setVisible(true);

    // Probeer de presentatie te laden
		try
		{
      // Als er geen argumenten zijn, laad dan een demo presentatie
			if (argv.length == 0)
			{
        // Laad de demo presentatie
				Accessor.getDemoAccessor().loadFile(presentation, "");
			}
			else
			{
        // Laad de gegeven presentatie
				new XMLAccessor().loadFile(presentation, argv[0]);
			}
			presentation.setSlideNumber(0);
		}
		catch (IOException exception)
		{
      // Toon een foutmelding
			JOptionPane.showMessageDialog(null, IOERR + exception, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}
