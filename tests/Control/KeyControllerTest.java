package Control;

import Jabberpoint.JabberPoint;
import Presentation.ControlPresentation;
import Presentation.Presentation;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;

public class KeyControllerTest {

    private ControlPresentation controlPresentation;
    private Presentation presentation;
    private KeyController keyController;
    private Component dummyComponent;

    @BeforeEach
    void setup() throws IOException
    {
        keyController = KeyController.getInstance();
        dummyComponent = new JFrame();
        JabberPoint.initialize(new String[0]);
        controlPresentation = ControlPresentation.getInstance();
        presentation = controlPresentation.getPresentation();
    }

    @Test
    public void keyController_nextPage_PageDown_expectPass() {
        assertEquals(0, presentation.getSlideNumber());
        keyController.keyPressed(new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, 'a'));
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void keyController_nextPage_Down_expectPass() {
        assertEquals(0, presentation.getSlideNumber());
        keyController.keyPressed(new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'a'));
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void keyController_nextPage_Enter_expectPass() {
        assertEquals(0, presentation.getSlideNumber());
        keyController.keyPressed(new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, 'a'));
        assertEquals(1, presentation.getSlideNumber());
    }
}

