package Control;

import Presentation.ControlPresentation;
import Presentation.Presentation;

public interface Command
{
    ControlPresentation controlPresentation = ControlPresentation.getInstance();

    public abstract String getShortcut();

    public void execute();
}
