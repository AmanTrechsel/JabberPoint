package Control.Commands;

import Control.Command;
import Presentation.Presentation;
import Presentation.ControlPresentation;

public class PageUp implements Command
{

    @Override
    public String getShortcut()
    {
        return null;
    }

    @Override
    public void execute()
    {
        controlPresentation.prevSlide();
    }
}
