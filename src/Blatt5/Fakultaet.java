package Blatt5;

public class Fakultaet
{
	public static long nFakult(final int n)
	{
		assert(n >= 0);

		System.out.println("nFakult von " + n);

		long nFak = (n <= 1) ? 1 : n * nFakult(n - 1);
		// Effiziente Kurzform f�r:
		// long nFak;
		// if (n <= 1)
		// {
		//   nFak = 1;
		// }
		// else
		// {
		//   nFak = n * nFakult(n - 1);
		// }

		System.out.println("R�ckgabewert " + nFak);
		return nFak;
	}
}
