package Control;

import Presentation.*;
import Accessor.XMLAccessor;
import Control.Commands.*;
import Accessor.Accessor;
import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.ldap.Control;
import javax.swing.JOptionPane;

public class MenuController extends MenuBar {

    private static MenuController menuController;
    private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
    private Presentation presentation; // Er worden commando's gegeven aan de presentatie

    private static final long serialVersionUID = 227L;

    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";


    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";
    
    public static MenuController getInstance()
    {
        if (MenuController.menuController == null)
        {
            MenuController.menuController = new MenuController(new Frame(""), ControlPresentation.getInstance().getPresentation());
        }
        return MenuController.menuController;
    }

    public MenuController(Frame frame, Presentation pres)
    {
        parent = frame;
        presentation = pres;

        CreateMenuItems();
    }
    
    private void CreateMenuItems()
    {
      MenuItem menuItem;

      ArrayList<Command> fileCommands = new ArrayList<Command>();
      fileCommands.add(new MenuOpen());
      fileCommands.add(new MenuNew());
      fileCommands.add(new MenuSave());
      fileCommands.add(new Exit());

      ArrayList<Command> viewCommands = new ArrayList<Command>();
      viewCommands.add(new PageDown());
      viewCommands.add(new PageUp());
      viewCommands.add(new PageGoTo());

      ArrayList<Command> helpCommands = new ArrayList<Command>();
      helpCommands.add(new ShowAbout());

      Menu fileMenu = new Menu(FILE);
      for (int i = 0; i < fileCommands.size(); i++)
      {
        if (i == fileCommands.size() - 1)
        {
          fileMenu.addSeparator();
        }
        Command command = fileCommands.get(i);
        fileMenu.add(menuItem = createMenuItem(command.getLabel(), command.getShortcut()));
        menuItem.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent actionEvent)
          {
            command.execute();
          }
        });
      }
      add(fileMenu);

      Menu viewMenu = new Menu(VIEW);
      for (Command command : viewCommands)
      {
        viewMenu.add(menuItem = createMenuItem(command.getLabel(), command.getShortcut()));
        menuItem.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent actionEvent)
          {
            command.execute();
          }
        });
      }
      add(viewMenu);

      Menu helpMenu = new Menu(HELP);
      for (Command command : helpCommands)
      {
        helpMenu.add(menuItem = createMenuItem(command.getLabel(), command.getShortcut()));
        menuItem.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent actionEvent)
          {
            command.execute();
          }
        });
      }
      setHelpMenu(helpMenu);
    }

    public Frame getFrame()
    {
        return this.parent;
    }

    // een menu-item aanmaken
    public MenuItem createMenuItem(String name, char shortcut) {
        return new MenuItem(name, new MenuShortcut(shortcut));
    }
}
