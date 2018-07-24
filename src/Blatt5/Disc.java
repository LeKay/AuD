package Blatt5;

import java.awt.Color;

public class Disc
{
	private int width;
	private int height = 20;
	private Color color;

	private static final Color[] COLORS = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE };

	public Disc(int width)
	{
		this.width = width;
		color = COLORS[width % COLORS.length];
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public Color getColor()
	{
		return color;
	}
}