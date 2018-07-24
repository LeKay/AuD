package Blatt9;

public class HeapSort
{
	// Versickere das Element mit Index zuversickern in dem Teilfeld von Index links bis einschlie�lich Index rechts
	public static void versickere(int[] array, int zuversickern, final int links, final int rechts)
	{
		// Im Gegensatz zur Vorlesung ben�tigt diese Methode vier Parameter, da der zu sortierende Bereich
		// nicht bei 0, sondern bei links anf�ngt. Linkes Kind von Knoten x: (x-links)*2+links+1
		final int x = array[zuversickern];
		int kind;

		// Linkes Kind
		while((kind=2*(zuversickern-links)+links+1) <= rechts)
		{
			// Gibt es auch ein rechts Kind, das einen gr��eren Schl�ssel hat?
			if ((kind < rechts) && (array[kind] < array[kind+1]))
				kind++;
			// Jetzt ist array[kind] in jedem Fall das gr��ere der beiden Kinder

			if (x < array[kind])
			{
				// x versickern lassen, array[kind] steigt nach oben
				array[zuversickern] = array[kind];

				zuversickern = kind;
			}
			else
			{
				// Endg�ltige Position gefunden
				break;
			}
		}

		// x an endg�ltige Position schreiben
		array[zuversickern] = x;
	}

	public static void heapsort(int[] array, final int links, final int rechts)
	{
		// 1. Phase: Heap herstellen
		for (int a = (rechts + links - 1) / 2; a >= links; a--)
			versickere(array, a, links, rechts);

		// 2. Phase: erstes und letztes Element vertauschen und versickern lassen
		for (int re = rechts; re > links; )
		{
			int temp = array[re];
			array[re] = array[links];
			array[links] = temp;

			if (--re > links)
				versickere(array, links, links, re);
		}
	}
}