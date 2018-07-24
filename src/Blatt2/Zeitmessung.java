package Blatt2;

public class Zeitmessung {

	public static void main( String[] args) {
		for(int i = 1000; i <= 1000000; i *= 10) {
			System.out.println("n = " + i + ":");
			Zeitmessung z = new Zeitmessung();
			StopUhr s = new StopUhr();
			s.start();
			z.func1(i);
			s.stop();
			System.out.print("func1: " + s.getDuration() + " | ");
			s.start();
			z.func6(i);
			s.stop();
			System.out.print("func6: " + s.getDuration() + " | ");
			s.start();
			z.func2(i);
			s.stop();
			System.out.print("func2: " + s.getDuration());
			System.out.println();
		}
	}

	private double tuwas()
	{
		return Math.random();
	}

	// Linear
	public double func1(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			summe += tuwas();

		return summe;
	}

	// Quadratisch
	public double func2(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			for(int b = 0; b < n; b++)
				summe += tuwas();

		return summe;
	}

	// log 2(n)
	public double func6(int n)
	{
		double summe = 0;

		while (n > 0)
		{
			summe += tuwas();
			n /= 2;
		}

		return summe;
	}
}
