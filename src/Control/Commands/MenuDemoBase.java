package Control.Commands;

import Accessor.Accessor;
import Accessor.DemoPresentation;
import Control.Command;
import Control.MenuController;
import Presentation.ControlPresentation;
import Presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuDemoBase implements Command
{
	@Override
	public String getLabel()
	{
		return "Basic Demo";
	}

	@Override
	public char getShortcut()
	{
		return '1';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().clear();
		Frame parent = MenuController.getInstance().getFrame();
		Accessor demoPresentation = new DemoPresentation();
		try
		{
			Presentation presentation = ControlPresentation.getInstance().getPresentation();
			demoPresentation.loadFile(presentation, null);
			presentation.setSlideNumber(0);
		}
		catch (IOException exception)
		{
			JOptionPane.showMessageDialog(parent, MenuController.IOEX + exception, MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
		}
		parent.repaint();
	}
}
