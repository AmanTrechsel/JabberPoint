package main.java.Accessor;

import main.java.Slide.Slide;
import main.java.Slide.BitmapItem;
import main.java.Presentation.*;

public class PlenairDemo extends Accessor
{
	@Override
	public void loadFile(Presentation presentation, String unusedFilename)
	{
		presentation.setTitle("Plenary Meeting Demo");

		Slide slide = new Slide();
		slide.setTitle("Welcome");
		slide.append(1, "Plenary Meeting Demo");
		slide.append(2, "This presentation showcases the features of our application for conducting plenary meetings.");
		slide.append(2, "Let's get started!");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Agenda Overview");
		slide.append(1, "Here is an overview of today's agenda:");
		slide.append(2, "1. Opening Remarks");
		slide.append(2, "2. Financial Report");
		slide.append(2, "3. Project Updates");
		slide.append(2, "4. Q&A Session");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Opening Remarks");
		slide.append(1, "We begin with some opening remarks.");
		slide.append(2, "This is a critical part of any plenary meeting as it sets the tone for the discussions to follow.");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Financial Report");
		slide.append(1, "Next, let's review the financial report.");
		slide.append(2, "Here are the key financial metrics for the current quarter:");
		slide.append(new BitmapItem(1, "src/main/resources/images/demo4.png"));
		slide.append(2, "We will discuss these figures in detail.");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Project Updates");
		slide.append(1, "Moving on to project updates.");
		slide.append(2, "We'll review the progress of ongoing projects and discuss any challenges encountered.");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Q&A Session");
		slide.append(1, "Finally, we'll open the floor for questions and answers.");
		slide.append(2, "This is an opportunity for everyone to clarify doubts and provide feedback.");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Conclusion");
		slide.append(1, "Thank you for participating in this Plenary Meeting Demo.");
		slide.append(2, "We appreciate your time and input.");
		presentation.append(slide);
	}

	@Override
	public void saveFile(Presentation presentation, String unusedFilename)
	{
		throw new IllegalStateException("Save operation is not supported in Plenary Meeting Demo");
	}
}
