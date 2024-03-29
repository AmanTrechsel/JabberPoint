package Control.Commands;

import Control.Command;
import Presentation.Presentation;

public class PageDown implements Command
{

    @Override
    public char getShortcut()
    {
        return ',';
    }

    @Override
    public String getLabel()
    {
        return "Previous";
    }

    @Override
    public void execute()
    {
        controlPresentation.prevSlide();
    }
}
