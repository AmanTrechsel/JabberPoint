package main.java.Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import main.java.Control.Commands.Exit;
import main.java.Control.Commands.PageDown;
import main.java.Control.Commands.PageUp;
import main.java.Presentation.ControlPresentation;

public class KeyController extends KeyAdapter
{
	// Constants
	private final Command NEXT_SLIDE_COMMAND = new PageDown();
	private final Command PREVIOUS_SLIDE_COMMAND = new PageUp();
	private final Command EXIT_COMMAND = new Exit();

	// Singleton
	private static KeyController keyController;

	public static KeyController getInstance()
	{
		if (KeyController.keyController == null)
		{
			KeyController.keyController = new KeyController();
		}

		return KeyController.keyController;
	}

	// Constructor
	private KeyController()
	{
	}

	// Check voor key events
	public void keyPressed(KeyEvent keyEvent)
	{
		// Check welke key is ingedrukt
		switch (keyEvent.getKeyCode())
		{
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				// Ga naar de volgende slide (PageDown, Down, Enter, +)
				PREVIOUS_SLIDE_COMMAND.execute();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				// Ga naar de vorige slide (PageUp, Up, -)
				NEXT_SLIDE_COMMAND.execute();
				break;
			case 'q':
			case 'Q':
				// Sluit de applicatie (Q)
				EXIT_COMMAND.execute();
				break;
			default:
				break;
		}
	}
}
