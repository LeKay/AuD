package Blatt11.Sortieren;

public class KnotenTyp
{
	public String name;
	public Verbindung nachbarn;
	public int anzVorg;

	public KnotenTyp(String s, Verbindung v)
	{
		name = s;
		nachbarn = v;
	}
}