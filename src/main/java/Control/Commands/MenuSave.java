package main.java.Control.Commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import main.java.Accessor.Accessor;
import main.java.Accessor.XMLAccessor;
import main.java.Control.Command;
import main.java.Control.MenuController;
import main.java.Presentation.ControlPresentation;

public class MenuSave implements Command
{
	@Override
	public String getLabel()
	{
		return "Save";
	}

	@Override
	public char getShortcut()
	{
		return 'S';
	}

	@Override
	public void execute()
	{
		Accessor xmlAccessor = new XMLAccessor();
		try
		{
			xmlAccessor.saveFile(ControlPresentation.getInstance().getPresentation(), MenuController.SAVEFILE);
		}
		catch (IOException exception)
		{
			JOptionPane.showMessageDialog(MenuController.getInstance().getFrame(), MenuController.IOEX + exception, MenuController.SAVEERR, JOptionPane.ERROR_MESSAGE);
		}
	}
}
