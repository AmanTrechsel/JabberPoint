package main.java.Control.Commands;

import main.java.Accessor.Accessor;
import main.java.Accessor.DemoPresentation;
import main.java.Control.Command;
import main.java.Control.MenuController;
import main.java.Presentation.ControlPresentation;
import main.java.Presentation.Presentation;

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
