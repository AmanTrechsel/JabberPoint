package Accessor;

import Slide.Slide;
import Slide.BitmapItem;
import Presentation.*;

class ImageDemo extends Accessor
{
  @Override
	public void loadFile(Presentation presentation, String unusedFilename)
	{
		presentation.setTitle("Image Demo Presentation");

		Slide slide = new Slide();
		slide.setTitle("Introduction");
		slide.append(1, "Welcome to the Image Demo Presentation");
		slide.append(2, "This presentation showcases the usage of images.");
		slide.append(2, "Let's get started!");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Using Images");
		slide.append(1, "Here we have an image of a beautiful landscape:");
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		slide.append(2, "Isn't it lovely?");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("More Images");
		slide.append(1, "Now, let's see another image:");
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		slide.append(2, "These flowers are breathtaking!");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Conclusion");
		slide.append(1, "Thank you for viewing our Image Demo Presentation.");
		slide.append(2, "We hope you enjoyed it!");
		presentation.append(slide);
	}

  @Override
	public void saveFile(Presentation presentation, String unusedFilename)
	{
		throw new IllegalStateException("Save operation is not supported in Image Demo Presentation");
	}
}
