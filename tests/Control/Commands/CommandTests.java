package Control.Commands;

import Jabberpoint.JabberPoint;
import Presentation.ControlPresentation;
import Presentation.Presentation;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandTests
{
    private ControlPresentation controlPresentation;
    private Presentation presentation;

    @BeforeEach
    void setup() throws IOException {
        JabberPoint.initialize(new String[0]);
        controlPresentation = ControlPresentation.getInstance();
        presentation = controlPresentation.getPresentation();
    }


    @Test
    void pageUp_execute_expectPass()
    {
        PageUp pageUp;
        pageUp = new PageUp();

        assertEquals(0, presentation.getSlideNumber());
        pageUp.execute();
        assertEquals(1, presentation.getSlideNumber());
    }
}