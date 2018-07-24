package Blatt5;

public class Logic implements Runnable
{
	Tower[] towers;
	private GUI gui;
	private long delay;
	public int numberOfDiscs;
	boolean switching;

	public Logic()
	{
		towers = new Tower[3];

		for (int a = 0; a < towers.length; a++)
			towers[a] = new Tower(a);

		create(3);
	}

	public void setGUI(GUI gui)
	{
		this.gui = gui;
	}

	public void setDelay(long delay)
	{
		this.delay = delay;
	}

	// Wird beim Bet�tigen von "Turm erstellen" ausgef�hrt
	public void create(int numberOf)
	{
		numberOfDiscs = numberOf;

		for (int a = 0; a < towers.length; a++)
			towers[a].fill(a==0 ? numberOf : 0);
	}

	// L�sst die "Animation" langsamer ablaufen
	public void delay()
	{
		try
		{
			Thread.sleep(delay);
		}
		catch (InterruptedException e)
		{
		}
	}

	public void transportDisc(int n, Tower t1, Tower t2, Tower t3)
	{
		if (switching)
			if (n >= 1)
			{
				transportDisc(n - 1, t1, t3, t2);	// 1. rekursiver Aufruf
				moveDisc(t1, t2); 					// Verschieben der Scheibe
				transportDisc(n - 1, t3, t2, t1);	// 2. rekursiver Aufruf

				gui.bufferedPaint();
			}
	}

	public void moveDisc(Tower t1, Tower t2)
	{
		if (switching)
		{
			t2.push(t1.pop());

			gui.bufferedPaint();
			delay();
		}
	}

	public void run()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
		}

		transportDisc(towers[0].size(), towers[0], towers[2], towers[1]);

		switching = false;
		gui.switchLabel();
	}
}