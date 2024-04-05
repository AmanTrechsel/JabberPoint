package main.java.Accessor;

import main.java.Presentation.Presentation;

import java.io.IOException;

public abstract class Accessor
{
	// Constants
	public static final String DEMO_NAME = "Demonstratie presentatie";
	public static final String DEFAULT_EXTENSION = ".xml";

	// Constructor
	public Accessor()
	{
	}

	// Laad een bestand
	abstract public void loadFile(Presentation presentation, String filename) throws IOException;

	// Sla een bestand op
	abstract public void saveFile(Presentation presentation, String filename) throws IOException;

}

