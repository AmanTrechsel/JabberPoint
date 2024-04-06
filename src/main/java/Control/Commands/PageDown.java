package main.java.Control.Commands;

import main.java.Control.Command;
import main.java.Presentation.ControlPresentation;

public class PageDown implements Command
{
	@Override
	public String getLabel()
	{
		return "Previous";
	}

	@Override
	public char getShortcut()
	{
		return ',';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().prevSlide();
	}
}
