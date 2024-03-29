package Control.Commands;

import Control.Command;
import Control.MenuController;
import Presentation.ControlPresentation;
import Presentation.Presentation;

public class MenuNew implements Command
{

    @Override
    public char getShortcut()
    {
        return 'N';
    }

    @Override
    public String getLabel()
    {
        return "New";
    }

    @Override
    public void execute()
    {
      ControlPresentation.getInstance().clear();
      MenuController.getInstance().getFrame().repaint();
    }
}
