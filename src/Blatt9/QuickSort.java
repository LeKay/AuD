package Blatt9;

public class QuickSort
{
	public static void quicksort(int[] array, final int links, final int rechts)
	{
		// Quicksort nur durchf�hren bei mindestens 2 Elementen innerhalb der Grenzen
		if (rechts <= links)
			return;

		final int pivot = array[(links + rechts) / 2];
		int li = links;
		int re = rechts;

		while (li <= re)
		{
			// Linker Zeiger
			while (array[li] < pivot)
				li++;

			// Rechter Zeiger
			while (array[re] > pivot)
				re--;

			if (li > re)
				break;

			// Elemente tauschen und Zeiger weiterbewegen (WICHTIG!)
			int temp = array[li];
			array[li++] = array[re];
			array[re--] = temp;
		}

		// Divide and conquer: rekursive Aufrufe f�r neue Teilbereiche
		if (links < re)
			quicksort(array, links, re);

		if (li < rechts)
			quicksort(array, li, rechts);
	}
}