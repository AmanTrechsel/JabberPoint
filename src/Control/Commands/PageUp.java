package Control.Commands;

import Control.Command;
import Presentation.ControlPresentation;

public class PageUp implements Command
{
	@Override
	public String getLabel()
	{
		return "Next";
	}

	@Override
	public char getShortcut()
	{
		return '.';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().nextSlide();
	}
}
