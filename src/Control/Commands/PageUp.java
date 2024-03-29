package Control.Commands;

import Control.Command;
import Presentation.Presentation;
import Presentation.ControlPresentation;

public class PageUp implements Command
{

    @Override
    public char getShortcut()
    {
        return '.';
    }

    @Override
    public String getLabel()
    {
        return "Next";
    }

    @Override
    public void execute()
    {
        controlPresentation.nextSlide();
    }
}
