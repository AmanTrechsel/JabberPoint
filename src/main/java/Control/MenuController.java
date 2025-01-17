package main.java.Control;

import main.java.Control.Commands.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import main.java.Accessor.SlideViewerFrame;

public class MenuController extends MenuBar
{
	// Constants
	private static final long serialVersionUID = 227L;

	protected static final String FILE = "File";
	protected static final String VIEW = "View";
	protected static final String DEMO = "Demos";
	protected static final String HELP = "Help";

	public static final String SAVEFILE = "dump.xml";

	public static final String IOEX = "IO Exception: ";
	public static final String LOADERR = "Load Error";
	public static final String SAVEERR = "Save Error";

	// Fields
	private Frame parent;

	// Singleton
	private static MenuController menuController;

	public static MenuController getInstance(SlideViewerFrame frame)
	{
		if (MenuController.menuController == null)
		{
			MenuController.menuController = new MenuController(frame);
		}

		return MenuController.menuController;
	}

	// Singleton (Zonder SlideViewerFrame)
	public static MenuController getInstance()
	{
		if (MenuController.menuController == null)
		{
			MenuController.menuController = new MenuController(SlideViewerFrame.getInstance());
		}

		return MenuController.menuController;
	}

	// Constructor
	private MenuController(Frame frame)
	{
		this.parent = frame;
		this.setupMenuItems();
	}

	// Setup van de menu-items
	private void setupMenuItems()
	{
		// Alle "File" menu-items
		ArrayList<Command> fileCommands = new ArrayList<Command>();
		fileCommands.add(new MenuOpen());
		fileCommands.add(new MenuNew());
		fileCommands.add(new MenuSave());
		fileCommands.add(new Exit());

		// Alle "View" menu-items
		ArrayList<Command> viewCommands = new ArrayList<Command>();
		viewCommands.add(new PageDown());
		viewCommands.add(new PageUp());
		viewCommands.add(new PageGoTo());

		// Alle "Demo" menu-items
		ArrayList<Command> demoCommands = new ArrayList<Command>();
		demoCommands.add(new MenuDemoBase());
		demoCommands.add(new MenuDemoImage());
		demoCommands.add(new MenuDemoPlenair());

		// Alle "Help" menu-items
		ArrayList<Command> helpCommands = new ArrayList<Command>();
		helpCommands.add(new ShowAbout());

		// Menu's toevogen
		add(this.createMenu(FILE, fileCommands, true));
		add(this.createMenu(VIEW, viewCommands, false));
		add(this.createMenu(DEMO, demoCommands, false));
		setHelpMenu(this.createMenu(HELP, helpCommands, false));
	}

	// Maakt een menu aan met de gegeven titel en commando's
	private Menu createMenu(String menuTitle, ArrayList<Command> commands, boolean addSeparator)
	{
		// Initialisatie van het menu
		Menu menu = new Menu(menuTitle);
		MenuItem menuItem;

		// Alle menu-items toevoegen
		for (int i = 0; i < commands.size(); i++)
		{
			// Commando ophalen
			Command command = commands.get(i);

			// Separator toevoegen indien nodig
			if (i == commands.size() - 1 && addSeparator)
			{
				menu.addSeparator();
			}

			// Menu-item toevoegen
			menu.add(menuItem = this.createMenuItem(command.getLabel(), command.getShortcut()));

			// Actie toevoegen aan het menu-item
			menuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent actionEvent)
				{
					// Commando uitvoeren
					executeCommand(command);
				}
			});
		}

		// Menu teruggeven
		return menu;
	}

	// Geeft de parent frame terug
	public Frame getFrame()
	{
		return this.parent;
	}

	// Voert een commando uit
	public void executeCommand(Command command)
	{
		command.execute();
	}

	// Maakt een menu-item aan met de gegeven naam en sneltoets
	public MenuItem createMenuItem(String name, char shortcut)
	{
		return new MenuItem(name, new MenuShortcut(shortcut));
	}
}
