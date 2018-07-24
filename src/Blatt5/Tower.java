package Blatt5;

import java.util.Stack;

public class Tower extends Stack<Disc>
{
	private int offset;

	public Tower(int offset)
	{
		this.offset = offset;
	}

	public void fill(int numberOf)
	{
		clear();

		for (int a = 0; a < numberOf; a++)
			push(new Disc(a));
	}

	public int getOffset()
	{
		return offset;
	}
}