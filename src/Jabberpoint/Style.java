package Jabberpoint;

import java.awt.Color;
import java.awt.Font;

public class Style
{
  // Het lettertype
  private static final String FONTNAME = "Helvetica";

  // Bevat de verschillende stijlen voor de verschillende levels
	private static Style[] styles;

	// Fields
	private int indent;
	private Color color;
	private Font font;
	private int fontSize;
	private int leading;

  // Maakt de verschillende stijlen aan
	public static void createStyles()
	{
		Style.styles = new Style[5];
		// De styles zijn hard gecodeerd
		Style.styles[0] = new Style(0, Color.yellow, 48, 20);
		Style.styles[1] = new Style(20, Color.blue, 40, 10);
		Style.styles[2] = new Style(50, Color.black, 36, 10);
		Style.styles[3] = new Style(70, Color.black, 30, 10);
		Style.styles[4] = new Style(90, Color.black, 24, 10);
	}

  // Constructor
	public Style(int indent, Color color, int points, int leading)
	{
		this.indent = indent;
		this.color = color;
		this.font = new Font(FONTNAME, Font.BOLD, fontSize = points);
		this.leading = leading;
	}

  // Getter voor de leading
	public int getLeading()
	{
		return this.leading;
	}

  // Getter voor de indent
	public int getIndent()
	{
		return this.indent;
	}

  // Getter voor de kleur
	public Color getColor()
	{
		return this.color;
	}

  // Haalt de style op voor een bepaald level
	public static Style getStyle(int level)
	{
		if (level >= Style.styles.length)
		{
			level = Style.styles.length - 1;
		}
		return Style.styles[level];
	}

  // Haaalt het lettertype op voor een bepaalde schaal
	public Font getFont(float scale)
	{
		return this.font.deriveFont(fontSize * scale);
	}

  // Converteert de style naar een string
  @Override
	public String toString()
	{
		return "[" + this.indent + "," + this.color + "; " + this.fontSize + " on " + this.leading + "]";
	}
}

