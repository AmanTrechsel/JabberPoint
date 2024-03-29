package Control.Commands;

import Control.Command;
import Presentation.Presentation;

public class Exit implements Command
{

    @Override
    public char getShortcut()
    {
        return 'Q';
    }

    @Override
    public String getLabel()
    {
        return "Exit";
    }

    @Override
    public void execute()
    {
        System.exit(0);
    }
}
