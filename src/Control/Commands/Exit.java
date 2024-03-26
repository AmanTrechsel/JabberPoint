package Control.Commands;

import Control.Command;
import Presentation.Presentation;

public class Exit implements Command
{

    @Override
    public String getShortcut()
    {
        return null;
    }

    @Override
    public void execute()
    {
        System.exit(0);
    }
}
