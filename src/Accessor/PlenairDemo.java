package Accessor;

import Slide.Slide;
import Presentation.*;

public class PlenairDemo extends Accessor
{
	@Override
	public void loadFile(Presentation presentation, String unusedFilename)
	{
		presentation.setTitle("Plenair Demo Presentation");
		Slide slide;
		slide = new Slide();
		slide.setTitle("Welkom bij de Plenair Demo!");
		slide.append(1, "Dit is een demonstratie van verschillende functies van JabberPoint.");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Bedankt voor het bekijken!");
		slide.append(1, "Dat was de Plenair Demo van JabberPoint.");
		presentation.append(slide);
	}

	@Override
	public void saveFile(Presentation presentation, String unusedFilename)
	{
		throw new IllegalStateException("Save As->PlenairDemo! aangeroepen");
	}
}