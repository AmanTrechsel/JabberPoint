package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import Control.Commands.Exit;
import Control.Commands.PageDown;
import Control.Commands.PageUp;

public class KeyController extends KeyAdapter {
    private final Command nextSlideCommand;
    private final Command prevSlideCommand;
    private final Command exitCommand;

    public KeyController() {
        nextSlideCommand = new PageDown();
        prevSlideCommand = new PageUp();
        exitCommand = new Exit();
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                nextSlideCommand.execute();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                prevSlideCommand.execute();
                break;
            case 'q':
            case 'Q':
                exitCommand.execute();
                break;
            default:
                break;
        }
    }
}
