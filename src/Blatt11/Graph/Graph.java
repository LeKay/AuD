package Blatt11.Graph;

import java.util.*;

public class Graph
{
	private static final int KNOTENZAHL = 15;
	private static boolean[] besucht;
	private KnotenTyp[] knoten = new KnotenTyp[KNOTENZAHL];

	public Graph()
	{
		knoten[0] = new KnotenTyp("San Francisco",
			new Verbindung(18, 1,
			new Verbindung(12, 3,
			new Verbindung(20, 4,
			new Verbindung(15, 14, null)))));
		knoten[1] = new KnotenTyp("San Rafael",
			new Verbindung(18, 0,
			new Verbindung(15, 2, null)));
		knoten[2] = new KnotenTyp ("Richmond",
			new Verbindung(15, 1,
			new Verbindung(15, 3,null)));
		knoten[3] = new KnotenTyp("Oakland",
			new Verbindung(12, 0,
			new Verbindung(15, 2,
			new Verbindung(20, 5, null))));
		knoten[4] = new KnotenTyp("San Mateo",
			new Verbindung(20, 0,
			new Verbindung(20, 5,
			new Verbindung(18, 6,
			new Verbindung(25, 13, null)))));
		knoten[5] = new KnotenTyp("Hayward",
			new Verbindung(20, 3,
			new Verbindung(20, 4,
			new Verbindung(14, 7, null))));
		knoten[6] = new KnotenTyp("Palo Alto",
			new Verbindung(18, 4,
			new Verbindung(15, 7,
			new Verbindung(10, 9, null))));
		knoten[7] = new KnotenTyp("Fremont",
			new Verbindung(14, 5,
			new Verbindung(15, 6,
			new Verbindung(20, 8, null))));
		knoten[8] = new KnotenTyp("San Jose",
			new Verbindung(20, 7,
			new Verbindung(15, 9,
			new Verbindung(60,11, null))));
		knoten[9] = new KnotenTyp("Santa Clara",
			new Verbindung(10, 6,
			new Verbindung(15, 8,
			new Verbindung(35,10, null))));
		knoten[10] = new KnotenTyp("Scotts Valley",
			new Verbindung(35, 9,
			new Verbindung(10,12, null)));
		knoten[11] = new KnotenTyp("Watsonville",
			new Verbindung(60, 8,
			new Verbindung(70,12, null)));
		knoten[12] = new KnotenTyp("Santa Cruz",
			new Verbindung(10, 9,
			new Verbindung(70,11,
			new Verbindung(50,13, null))));
		knoten[13] = new KnotenTyp("Half Moon Bay",
			new Verbindung(25, 4,
			new Verbindung(50,12,
			new Verbindung(15,14, null))));
		knoten[14] = new KnotenTyp("Pacifica",
			new Verbindung(15, 0,
			new Verbindung(15, 13, null)));
	}

	private int isKante(final int k1, final int k2)
	{
		Verbindung vp = knoten[k1].nachbarn;
		while (vp != null)
		{
			if (vp.getZiel() == k2)
				return vp.getLaenge();

			vp = vp.next;
		}

		return 0;
	}

	// Tiefensuche
	public void dfsRekursiv(final int k)
	{
		besucht = new boolean[KNOTENZAHL];
		rekDfs(k);
	}

	private void rekDfs(final int k)
	{
		besucht[k] = true;
		System.out.println(knoten[k].getName());

		for (int a = 0; a < KNOTENZAHL; a++)
			if (isKante(k, a) > 0)
				if (!besucht[a])
					rekDfs(a);
	}

	// Breitensuche
	public void bfsIterativ(final int start)
	{
		boolean[] besucht = new boolean[KNOTENZAHL];
		Deque<Integer> q = new LinkedList<Integer>();

		q.addLast(start);
		besucht[start] = true;

		while (q.size() > 0)
		{
			int k = q.removeFirst();
			System.out.println(knoten[k].getName());

			for (int a = 0 ; a < KNOTENZAHL; a++)
				if (isKante(k, a) > 0)
					if (!besucht[a])
					{
						q.addLast(a);
						besucht[a] = true;
					}
		}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph();

		System.out.println("Start Breitendurchlauf mit " + g.knoten[1].getName());
		g.bfsIterativ(1);

		System.out.println("\nStart Tiefendurchlauf mit " + g.knoten[1].getName());
		g.dfsRekursiv(1);
	}
}