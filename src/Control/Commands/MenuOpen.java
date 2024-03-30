package Control.Commands;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import Accessor.Accessor;
import Accessor.XMLAccessor;
import Control.Command;
import Control.MenuController;
import Presentation.ControlPresentation;
import Presentation.Presentation;

public class MenuOpen implements Command
{
	@Override
	public String getLabel()
	{
		return "Open";
	}

	@Override
	public char getShortcut()
	{
		return 'O';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().clear();
		Frame parent = MenuController.getInstance().getFrame();
		Accessor xmlAccessor = new XMLAccessor();
		try
		{
			Presentation presentation = ControlPresentation.getInstance().getPresentation();
			xmlAccessor.loadFile(presentation, MenuController.TESTFILE);
			presentation.setSlideNumber(0);
		}
		catch (IOException exception)
		{
			JOptionPane.showMessageDialog(parent, MenuController.IOEX + exception, MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
		}
		parent.repaint();
	}
}
