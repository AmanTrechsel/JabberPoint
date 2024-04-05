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
        this.controlPresentation = ControlPresentation.getInstance();
        this.presentation = this.controlPresentation.getPresentation();
        this.pageUp = new PageUp();
        this.pageDown = new PageDown();
    }

    @Test
    void pageUp_execute_expectPass()
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.pageUp.execute();
        assertEquals(1, this.presentation.getSlideNumber());
    }

    @Test
    void pageDown_execute_expectPass()
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.pageUp.execute();
        assertEquals(1, this.presentation.getSlideNumber());
        this.pageDown.execute();
        assertEquals(0, this.presentation.getSlideNumber());
    }

}