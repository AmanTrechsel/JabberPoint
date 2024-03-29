package Control.Commands;

import Control.AboutBox;
import Control.Command;
import Presentation.Presentation;

public class ShowAbout implements Command
{

    @Override
    public char getShortcut()
    {
        return 'H';
    }

    @Override
    public String getLabel()
    {
        return "About";
    }

    @Override
    public void execute()
    {
        AboutBox.show();
    }
}
