package Blatt11.Uebung;

import java.util.*;

public class Graph
{
	private static final int KNOTENZAHL = 6;
	private static boolean[] besucht;
	private KnotenTyp[] knoten;
	private boolean[][] matrix = {
			{false, true, false, false, false, false},
			{false, false, true, true, false, false},
			{false, true, false, true, false, false},
			{false, true, true, false, false, false},
			{false, false, false, false, true, false},
			{false, false, false, false, false, true},
		};

	public Graph()
	{
		knoten  = new KnotenTyp[KNOTENZAHL];
		knoten[0] = new KnotenTyp("A");
		knoten[1] = new KnotenTyp("B");
		knoten[2] = new KnotenTyp("C");
		knoten[3] = new KnotenTyp("D");
		knoten[4] = new KnotenTyp("E");
		knoten[5] = new KnotenTyp("F");
	}

	private boolean isKante(int k1, int k2)
	{
		// TODO
		return false;
	}

	// Tiefensuche
	public void Zusammenhangskomponenten()
	{
		besucht = new boolean [KNOTENZAHL];

		// TODO
	}

	// TODO

	public static void main(String[] args)
	{
		new Graph().Zusammenhangskomponenten();
	}
}