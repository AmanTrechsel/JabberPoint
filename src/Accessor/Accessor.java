package Accessor;

import Presentation.Presentation;

import java.io.IOException;

public abstract class Accessor
{
  // Constants
	public static final String DEMO_NAME = "Demonstratie presentatie";
	public static final String DEFAULT_EXTENSION = ".xml";

  // Laad de demo presentatie
	public static Accessor getDemoAccessor()
	{
		return new DemoPresentation();
	}

  // Constructor
	public Accessor()
	{
	}

  // Laad een bestand
	abstract public void loadFile(Presentation p, String fn) throws IOException;

  // Sla een bestand op
	abstract public void saveFile(Presentation p, String fn) throws IOException;

}

