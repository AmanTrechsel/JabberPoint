package Presentation;

public class ControlPresentation
{
    private Presentation presentation;
    private static ControlPresentation controlPresentation;

    private ControlPresentation()
    {
    }

    public static ControlPresentation getInstance()
    {
        if (ControlPresentation.controlPresentation == null)
        {
            ControlPresentation.controlPresentation = new ControlPresentation();
        }
        return ControlPresentation.controlPresentation;
    }

    public Presentation getPresentation()
    {
        return this.presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    // ga naar de vorige slide tenzij je aan het begin van de presentatie bent
    public void prevSlide() {
        if (presentation.getSlideNumber() > 0) {
            presentation.setSlideNumber(presentation.getSlideNumber() - 1);
        }
    }

    // Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
    public void nextSlide() {
        if (presentation.getSlideNumber() < (presentation.getShowList().size()-1)) {
            presentation.setSlideNumber(presentation.getSlideNumber() + 1);
        }
    }

    // Ga naar een specifieke slide
    public void setSlideNumber(int slideNumber) {
        if (slideNumber >= 0 && slideNumber < presentation.getShowList().size()) {
            presentation.setSlideNumber(slideNumber);
        }
    }

    // Wis de presentatie
    public void clear() {
        presentation.clear();
    }
}
