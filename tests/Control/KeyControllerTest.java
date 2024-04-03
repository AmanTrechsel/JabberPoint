package Control;

import Jabberpoint.JabberPoint;
import Presentation.ControlPresentation;
import Presentation.Presentation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void setup() throws IOException {
        keyController = KeyController.getInstance();
        dummyComponent = new JFrame();
        JabberPoint.initialize(new String[0]);
        controlPresentation = ControlPresentation.getInstance();
        presentation = controlPresentation.getPresentation();
    }

    @ParameterizedTest
    @ValueSource(ints = { KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, '+' })
    void keyController_nextPage(int keyCode) {
        assertEquals(0, presentation.getSlideNumber());
        keyController.keyPressed(new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
        assertEquals(1, presentation.getSlideNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = { KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, '-' })
    void keyController_prevPage(int keyCode) {
        presentation.setSlideNumber(1);
        assertEquals(1, presentation.getSlideNumber());
        keyController.keyPressed(new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
        assertEquals(0, presentation.getSlideNumber());
    }
}
