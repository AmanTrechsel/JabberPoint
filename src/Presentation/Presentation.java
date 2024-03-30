package Presentation;

import Slide.Slide;

import java.util.ArrayList;

public class Presentation
{
  // Fields
	private String showTitle;
	private ArrayList<Slide> showList;
	private int currentSlideNumber;
	private SlideViewerComponent slideViewComponent;

  // Constructor
	public Presentation(SlideViewerComponent slideViewerComponent)
	{
    this.showTitle = "";
    this.showList = new ArrayList<Slide>();
    this.currentSlideNumber = 0;
		this.slideViewComponent = slideViewerComponent;
		this.clear();
	}

  // Constructor (Zonder SlideViewerComponent)
	public Presentation()
	{
		this.showTitle = "";
    this.showList = new ArrayList<Slide>();
    this.currentSlideNumber = 0;
		this.slideViewComponent = null;
		this.clear();
	}

  // Getter voor de titel
	public String getTitle()
	{
		return this.showTitle;
	}

  // Setter voor de titel
	public void setTitle(String newTitle)
	{
		this.showTitle = newTitle;
	}

  // Getter voor de showList
	public ArrayList<Slide> getShowList()
	{
		return this.showList;
	}

  // Setter voor de SlideViewerComponent
	public void setShowView(SlideViewerComponent slideViewerComponent)
	{
		this.slideViewComponent = slideViewerComponent;
	}

  // Getter voor het huidige-slide-nummer
	public int getSlideNumber()
	{
		return this.currentSlideNumber;
	}

	// Setter voor het huidige-slide-nummer
	public void setSlideNumber(int number)
	{
		this.currentSlideNumber = number;
		if (this.slideViewComponent != null)
		{
			this.slideViewComponent.update(this, this.getCurrentSlide());
		}
	}

  // Geeft de grootte van de presentatie
	public int getSize()
	{
		return this.showList.size();
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear()
	{
		this.showList = new ArrayList<Slide>();
		this.setSlideNumber(-1);
	}

	// Voeg een slide toe aan de presentatie
	public void append(Slide slide)
	{
		this.showList.add(slide);
	}

	// Geeft de slide met het gegeven index
	public Slide getSlide(int index)
	{
    // Als de index niet bestaat, geef null terug
		if (index < 0 || index >= getSize())
		{
			return null;
		}

    // Geef de slide terug
		return (Slide) this.showList.get(index);
	}

	// Geeft de huidige Slide
	public Slide getCurrentSlide()
	{
		return this.getSlide(this.currentSlideNumber);
	}

  // Sluit de applicatie
	public void exit(int exitCode)
	{
		System.exit(exitCode);
	}
}

