package Jabberpoint;

import Accessor.*;
import Presentation.*;

import javax.swing.JOptionPane;
import java.io.IOException;


public class JabberPoint
{
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/** Het Main Programma */
	public static void main(String argv[])
	{

		Style.createStyles();
		Presentation presentation = new Presentation();

		ControlPresentation controlPresentation = ControlPresentation.getInstance();
		controlPresentation.setPresentation(presentation);

		new SlideViewerFrame(JABVERSION);
		try
		{
			if (argv.length == 0)
			{ // een demo presentatie
				Accessor.getDemoAccessor().loadFile(presentation, "");
			}
			else
			{
				new XMLAccessor().loadFile(presentation, argv[0]);
			}
			presentation.setSlideNumber(0);
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
