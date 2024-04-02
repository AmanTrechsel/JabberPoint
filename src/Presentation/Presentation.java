package Presentation;

import Slide.Slide;

import java.util.ArrayList;

public class Presentation
{
	// Fields
	private String showTitle;
	private ArrayList<Slide> showList;
	private int currentSlideNumber;
	private ArrayList<PresentationListener> presentationListeners;
	
	// Constructor
	public Presentation(PresentationListener presentationListener)
	{
		this.showTitle = "";
		this.showList = new ArrayList<Slide>();
		this.currentSlideNumber = 0;
		this.presentationListeners = new ArrayList<>();
		this.addPresentationListener(presentationListener);
		this.clear();
	}
	
	// Constructor (Zonder SlideViewerComponent)
	public Presentation()
	{
		this.showTitle = "";
		this.showList = new ArrayList<Slide>();
		this.currentSlideNumber = 0;
		this.presentationListeners = new ArrayList<>();
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
	
	// Getter voor het huidige-slide-nummer
	public int getSlideNumber()
	{
		return this.currentSlideNumber;
	}
	
	// Setter voor het huidige-slide-nummer
	public void setSlideNumber(int number)
	{
		this.currentSlideNumber = number;
		this.updatePresentationListeners();
	}
	
	// Geeft de grootte van de presentatie
	public int getSize()
	{
		return this.showList.size();
	}
	
	// Voegt een PresentationListener toe
	public void addPresentationListener(PresentationListener presentationListener)
	{
		this.presentationListeners.add(presentationListener);
	}
	
	// Verwijdert een PresentationListener
	public void removePresentationListener(PresentationListener presentationListener)
	{
		this.presentationListeners.remove(presentationListener);
	}
	
	// Update alle PresentationListeners
	public void updatePresentationListeners()
	{
		// Loop door alle PresentationListeners
		for (PresentationListener presentationListener : this.presentationListeners)
		{
			// Update de PresentationListener
			presentationListener.update(this, this.getCurrentSlide());
		}
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

