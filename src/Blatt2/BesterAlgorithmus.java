package Blatt2;

import Blatt1.Matrix;

public class BesterAlgorithmus
{
	// 1000n
	public static double g1(int n)
	{
		return 1000*n;
	}

	// 100n * log2(n+1)
	public static double g2(int n)
	{
		return 100*n * Math.log10(n+1) / Math.log10(2);
	}

	// 10 * n * n
	public static double g3(int n)
	{
		return 10*n*n;
	}

	// n * n * n
	public static double g4(int n)
	{
		return n*n*n;
	}

	// 2 hoch n
	public static double g5(int n)
	{
		return Math.pow(2,n);
	}

	// n!
	public static double g6(int n)
	{
		int r = 1;
		for(int i = 2; i <= n; i++)
			r *= i;
		return r;
	}

	// Bestimmt fuer alle 6 Funktionen den Wert von
	// gi(n) und gibt den Index der Funktion mit
	// dem minimalen Wert zurueck
	public static int gewinnerFuerN(int n)
	{
		double[] erg = new double[6];
		erg[0] = g1(n);
		erg[1] = g2(n);
		erg[2] = g3(n);
		erg[3] = g4(n);
		erg[4] = g5(n);
		erg[5] = g6(n);
		int min = 0;
		for(int i = 1; i < 6; i++) {
			//Stack Overflow Protection
			if(erg[i] < erg[min] && erg[i] > 0)
				min = i;
		}
		for(double d : erg)
			System.out.print(d + " ");
		System.out.println("Best: " + min);
		return min+1;
	}

	// Gibt f�r jede Zahl n zwischen 1 und 2000 aus, welcher der
	// 6 Algorithmen (A1 .. A6) f�r das betrachtete n der Beste ist
	public static void main(String[] args)
	{
		for(int i = 1; i <= 2000; i++) {
			System.out.println(i + ": g" + gewinnerFuerN(i));
		}
	}
}