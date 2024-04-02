package Jabberpoint;

import Accessor.*;
import Presentation.*;

import javax.swing.JOptionPane;
import java.io.IOException;

public class JabberPoint {
	// Constants
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";

	public static void initialize(String[] argv) throws IOException {
		// Creëer de verschillende stijlen
		Style.createStyles();

		// Creëer de presentatie
		Presentation presentation = new Presentation();

		// Haal de ControlPresentation op en zet de presentatie erin
		ControlPresentation controlPresentation = ControlPresentation.getInstance();
		controlPresentation.setPresentation(presentation);

		// Probeer de presentatie te laden
		if (argv.length == 0) {
			Accessor.getDemoAccessor().loadFile(presentation, "");
		} else {
			new XMLAccessor().loadFile(presentation, argv[0]);
		}
		presentation.setSlideNumber(0);
	}

	// Het hoofdprogramma
	public static void main(String argv[]) {
		try {
			initialize(argv);
			// Maak SlideViewerFrame zichtbaar
			SlideViewerFrame.getInstance().setVisible(true);
		} catch (IOException exception) {
			// Toon een foutmelding
			JOptionPane.showMessageDialog(null, IOERR + exception, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}