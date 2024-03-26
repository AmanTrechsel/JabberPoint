package Control.Commands;

import Control.AboutBox;
import Control.Command;
import Presentation.Presentation;

public class ShowAbout implements Command
{

    private AboutBox aboutBox;

    @Override
    public String getShortcut()
    {
        return null;
    }

    @Override
    public void execute()
    {

    }
}
