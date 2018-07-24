package Blatt9;

public class BasicSort
{
	// Insertionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void insertionsort(int[] array, final int links, final int rechts)
	{
		for (int a = links + 1; a <= rechts; a++)
		{
			int temp = array[a];

			// Einf�geposition finden
			int b = a - 1;
			while ((b >= links) && (array[b] > temp))
				array[b+1] = array[b--];

			array[b+1] = temp;
		}
	}

	// Selectionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void selectionsort(int[] array, final int links, final int rechts)
	{
		for (int a = links; a < rechts; a++)
		{
			// Kleinstes Element im unsortierten Teil finden
			int min = a;

			for (int b = a + 1; b <= rechts; b++)
				if (array[min] > array[b])
					min = b;

			// Elemente tauschen
			int temp = array[min];
			array[min] = array[a];
			array[a] = temp;
		}
	}

	// Bubblesort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void bubblesort(int[] array, final int links, final int rechts)
	{
		int re = rechts;
		boolean getauscht;

		do
		{
			getauscht = false;

			for (int a = links; a < re; a++)
				if (array[a] > array[a+1])
				{
					// Elemente tauschen
					int temp = array[a];
					array[a] = array[a+1];
					array[a+1] = temp;

					getauscht = true;
				}

			// Unsortierten Bereich verkleinern
			re--;
		}
		while (getauscht);
	}
}