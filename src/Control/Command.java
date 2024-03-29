package Control;

public interface Command
{
  // Label van de menu commando
	public abstract String getLabel();

  // Shortcut van de menu commando
	public abstract char getShortcut();

  // De code die wordt uitgevoerd wanneer het commando wordt aangeroepen
	public abstract void execute();
}
