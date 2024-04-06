package main.java.Control.Commands;

import main.java.Control.Command;
import main.java.Control.MenuController;
import main.java.Presentation.ControlPresentation;

public class MenuNew implements Command
{
	@Override
	public String getLabel()
	{
		return "New";
	}

	@Override
	public char getShortcut()
	{
		return 'N';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().clear();
		MenuController.getInstance().getFrame().repaint();
	}
}
