package Presentation;

import Slide.Slide;

public interface PresentationListener
{
	// Receiver voor wanneer de presentatie wordt geupdate
	public abstract void update(Presentation presentation, Slide slide);
}
