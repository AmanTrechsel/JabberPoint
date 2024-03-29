package Control.Commands;

import Control.AboutBox;
import Control.Command;
import Presentation.Presentation;

public class ShowAbout implements Command
{

    @Override
    public String getShortcut()
    {
        return null;
    }

    @Override
    public void execute()
    {
        AboutBox.show();
    }
}
