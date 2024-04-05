package main.java.Control.Commands;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.*;

import main.java.Accessor.Accessor;
import main.java.Accessor.XMLAccessor;
import main.java.Control.Command;
import main.java.Control.MenuController;
import main.java.Presentation.ControlPresentation;
import main.java.Presentation.Presentation;

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
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(parent);
		try
		{
			Presentation presentation = ControlPresentation.getInstance().getPresentation();
			xmlAccessor.loadFile(presentation, fileChooser.getSelectedFile().getPath());
			presentation.setSlideNumber(0);
		}
		catch (IOException exception)
		{
			JOptionPane.showMessageDialog(parent, MenuController.IOEX + exception, MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
		}
		parent.repaint();
	}
}
