package Blatt11.Sortieren;

public class Verbindung
{
	public int laenge;
	public int wohin;
	public Verbindung next;

	public Verbindung(int l, int w, Verbindung v)
	{
		laenge = 1;
		wohin = w;
		next = v;
	}
}