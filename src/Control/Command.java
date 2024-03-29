package Control;

import Presentation.ControlPresentation;
import Presentation.Presentation;

public interface Command
{
    ControlPresentation controlPresentation = ControlPresentation.getInstance();

    public abstract char getShortcut();

    public abstract String getLabel();

    public void execute();
}
