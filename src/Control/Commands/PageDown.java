package Control.Commands;

import Control.Command;
import Presentation.ControlPresentation;

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
