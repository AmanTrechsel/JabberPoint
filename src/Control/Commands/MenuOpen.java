package Control.Commands;

import java.awt.Frame;
import java.awt.Menu;
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
  protected static final String TESTFILE = "test.xml";
  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Load Error";

    @Override
    public char getShortcut()
    {
        return 'O';
    }

    @Override
    public String getLabel()
    {
        return "Open";
    }

    @Override
    public void execute()
    {
      ControlPresentation.getInstance().clear();
      Frame parent = MenuController.getInstance().getFrame();
      Accessor xmlAccessor = new XMLAccessor();
      try {
          Presentation presentation = ControlPresentation.getInstance().getPresentation();
          xmlAccessor.loadFile(presentation, TESTFILE);
          presentation.setSlideNumber(0);
      } catch (IOException exc) {
          JOptionPane.showMessageDialog(parent, IOEX + exc,
                  LOADERR, JOptionPane.ERROR_MESSAGE);
      }
      parent.repaint();
    }
}
