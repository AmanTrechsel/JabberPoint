package Control.Commands;

import Control.AboutBox;
import Control.Command;

public class ShowAbout implements Command
{
	@Override
	public String getLabel()
	{
		return "About";
	}

	@Override
	public char getShortcut()
	{
		return 'H';
	}

	@Override
	public void execute()
	{
		AboutBox.show();
	}
}
