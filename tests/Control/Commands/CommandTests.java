package Control.Commands;

import Jabberpoint.JabberPoint;
import Presentation.ControlPresentation;
import Presentation.Presentation;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandTests
{
    private ControlPresentation controlPresentation;
    private Presentation presentation;
    private PageUp pageUp;
    private PageDown pageDown;

    @BeforeEach
    void setup() throws IOException {
        JabberPoint.initialize(new String[0]);
        controlPresentation = ControlPresentation.getInstance();
        presentation = controlPresentation.getPresentation();
        pageUp = new PageUp();
        pageDown = new PageDown();
    }


    @Test
    void pageUp_execute_expectPass()
    {
        assertEquals(0, presentation.getSlideNumber());
        pageUp.execute();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void pageDown_execute_expectPass()
    {
        assertEquals(0, presentation.getSlideNumber());
        pageUp.execute();
        assertEquals(1, presentation.getSlideNumber());
        pageDown.execute();
        assertEquals(0, presentation.getSlideNumber());
    }

}