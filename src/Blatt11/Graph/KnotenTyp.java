package Blatt11.Graph;

public class KnotenTyp
{
	private String name;
	public Verbindung nachbarn;

	public KnotenTyp(String s, Verbindung v)
	{
		name = s;
		nachbarn = v;
	}

	public String getName()
	{
		return name;
	}
}