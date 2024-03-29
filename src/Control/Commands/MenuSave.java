package Control.Commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import Accessor.Accessor;
import Accessor.XMLAccessor;
import Control.Command;
import Control.MenuController;
import Presentation.ControlPresentation;
import Presentation.Presentation;

public class MenuSave implements Command
{
  protected static final String SAVEERR = "Save Error";
  protected static final String SAVEFILE = "dump.xml";
  protected static final String IOEX = "IO Exception: ";

    @Override
    public char getShortcut()
    {
        return 'S';
    }

    @Override
    public String getLabel()
    {
        return "Save";
    }

    @Override
    public void execute()
    {
      Accessor xmlAccessor = new XMLAccessor();
      try {
          xmlAccessor.saveFile(ControlPresentation.getInstance().getPresentation(), SAVEFILE);
      } catch (IOException exc) {
          JOptionPane.showMessageDialog(MenuController.getInstance().getFrame(), IOEX + exc,
                  SAVEERR, JOptionPane.ERROR_MESSAGE);
      }
    }
}
