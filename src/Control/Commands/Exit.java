package Control.Commands;

import Control.Command;

public class Exit implements Command
{
	@Override
	public String getLabel()
	{
		return "Exit";
	}

	@Override
	public char getShortcut()
	{
		return 'Q';
	}

	@Override
	public void execute()
	{
		System.exit(0);
	}
}
