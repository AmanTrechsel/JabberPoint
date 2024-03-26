package Control.Commands;

import Control.Command;
import Presentation.Presentation;

public class PageDown implements Command
{

    @Override
    public String getShortcut()
    {
        return null;
    }

    @Override
    public void execute()
    {
        controlPresentation.nextSlide();
    }
}
