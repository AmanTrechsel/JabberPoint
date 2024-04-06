package main.java.Control.Commands;

import javax.swing.JOptionPane;

import main.java.Control.Command;
import main.java.Presentation.ControlPresentation;

public class PageGoTo implements Command
{
	protected static final String PAGENR = "Page number?";

	@Override
	public String getLabel()
	{
		return "Go to";
	}

	@Override
	public char getShortcut()
	{
		return 'G';
	}

	@Override
	public void execute()
	{
		String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
		int pageNumber = Integer.parseInt(pageNumberStr);
		ControlPresentation.getInstance().setSlideNumber(pageNumber - 1);
	}
}
