package Presentation;

public class ControlPresentation
{
	// Huidege presentatie
	private Presentation presentation;

	// Singleton
	private static ControlPresentation controlPresentation;

	public static ControlPresentation getInstance()
	{
		if (ControlPresentation.controlPresentation == null)
		{
			ControlPresentation.controlPresentation = new ControlPresentation();
		}

		return ControlPresentation.controlPresentation;
	}

	// Constructor
	private ControlPresentation()
	{
	}

	// Getter voor de presentatie
	public Presentation getPresentation()
	{
		return this.presentation;
	}

	// Setter voor de presentatie
	public void setPresentation(Presentation presentation)
	{
		this.presentation = presentation;
	}

	// Gaat naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide()
	{
		if (this.presentation.getSlideNumber() > 0)
		{
			this.presentation.setSlideNumber(this.presentation.getSlideNumber() - 1);
		}
	}

	// Gaat naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide()
	{
		if (this.presentation.getSlideNumber() < (this.presentation.getShowList().size() - 1))
		{
			this.presentation.setSlideNumber(this.presentation.getSlideNumber() + 1);
		}
	}

	// Gaat naar een specifieke slide
	public void setSlideNumber(int slideNumber)
	{
		if (slideNumber >= 0 && slideNumber < presentation.getShowList().size())
		{
			this.presentation.setSlideNumber(slideNumber);
		}
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear()
	{
		this.presentation.clear();
	}

	// Zet een nieuwe SlideViewerComponent
	public void setShowView(SlideViewerComponent slideViewerComponent)
	{
		this.presentation.setShowView(slideViewerComponent);
	}
}
