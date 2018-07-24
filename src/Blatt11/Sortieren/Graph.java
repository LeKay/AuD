package Blatt11.Sortieren;

import Blatt11.Sortieren.KnotenTyp;

import java.util.*;

public class Graph
{
	private int maxKnotenzahl;
	private int aktKnotenzahl;
	KnotenTyp[] knoten;

	public Graph(int maxKnotenzahl)
	{
		assert(maxKnotenzahl >= 2);

		knoten = new KnotenTyp[this.maxKnotenzahl = maxKnotenzahl];
	}

	public int suchenUndEinfuegen(final String knotenname)
	{
		for (int a = 0; a < aktKnotenzahl; a++)
			if (knoten[a].name.compareTo(knotenname) == 0)
				return a;

		// Knoten existiert noch nicht, wird neu eingef�gt
		knoten[aktKnotenzahl] = new KnotenTyp(knotenname, null);

		return aktKnotenzahl++;
	}

	private int getKante(final int k1, final int k2)
	{
		Verbindung vp = knoten[k1].nachbarn;
		while (vp != null)
		{
			if (vp.wohin == k2)
				return vp.laenge;

			vp = vp.next;
		}

		return 0;
	}

	public void addKante(final int k1, final int k2)
	{
		knoten[k1].nachbarn = new Verbindung(1, k2, knoten[k1].nachbarn);
		knoten[k2].anzVorg++;
	}

	public LinkedList<Integer> topSort()
	{
		// Liste der Ergebnisknoten
		LinkedList<Integer> tp = new LinkedList<Integer>();
		boolean besucht[] = new boolean [aktKnotenzahl];

		boolean gefunden;
		do
		{
			gefunden = false;

 			// Knoten ohne Vorg�nger suchen
			for (int a = 0; a < aktKnotenzahl; a++)
				if (knoten[a].anzVorg == 0 && !besucht[a])
				{
					gefunden = true;
					besucht[a] = true;

					tp.addLast(a);

					// Alle ausgehnden Kanten von a verfolgen
					Verbindung listPtr = knoten[a].nachbarn;
					while (listPtr != null)
					{
						knoten[listPtr.wohin].anzVorg--;
						listPtr = listPtr.next;
					}
				}
		}
		while (gefunden);

		if (tp.size() != aktKnotenzahl)
			System.out.println("Graph enthielt Zyklen oder war nicht zusammenh�ngend!");

		return tp;
	}

	public void ausgeben()
	{
		for (int a = 0; a < maxKnotenzahl; a++)
			if (knoten[a] != null)
			{
				System.out.print("Knoten: " + knoten[a].name + "  Position im Feld: " + a + "  Anzahl der Vorg�nger: " + knoten[a].anzVorg);
				System.out.print("  Kanten zu anderen Knoten: ");

				Verbindung next = knoten[a].nachbarn;
				while (next != null)
				{
					System.out.print(knoten[a].name + "->" + knoten[next.wohin].name + " ");
					next = next.next;
				}

				System.out.println();
			}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(5);

		g.addKante(g.suchenUndEinfuegen("a"), g.suchenUndEinfuegen("b"));
		g.addKante(g.suchenUndEinfuegen("b"), g.suchenUndEinfuegen("c"));
		g.addKante(g.suchenUndEinfuegen("c"), g.suchenUndEinfuegen("d"));
		g.addKante(g.suchenUndEinfuegen("c"), g.suchenUndEinfuegen("e"));
		g.addKante(g.suchenUndEinfuegen("a"), g.suchenUndEinfuegen("c"));

		System.out.println("Aufgebauter Graph:");
		g.ausgeben();

		System.out.println("\nGraph in topoligischer Reihenfolge:");
		LinkedList<Integer> tp = g.topSort();

		ListIterator<Integer> it = tp.listIterator();
		while (it.hasNext())
			System.out.print(g.knoten[it.next()].name + " ");
	}
}