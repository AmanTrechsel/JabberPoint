package Control.Commands;

import Accessor.Accessor;
import Accessor.ImageDemo;
import Control.Command;
import Control.MenuController;
import Presentation.ControlPresentation;
import Presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuDemoImage implements Command
{
	@Override
	public String getLabel()
	{
		return "Image Demo";
	}

	@Override
	public char getShortcut()
	{
		return '2';
	}

	@Override
	public void execute()
	{
		ControlPresentation.getInstance().clear();
		Frame parent = MenuController.getInstance().getFrame();
		Accessor demoPresentation = new ImageDemo();
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
