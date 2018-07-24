package Blatt10;

public class Professor implements IHashable
{
	private String Name;
	private long Hausruf;

	public String getName()
	{
		return Name;
	}

	public long getHausruf()
	{
		return Hausruf;
	}

	public Professor(String name, int Hausruf)
	{
		this.Name = name;
		this.Hausruf  = Hausruf;
	}

	// Hash-Wert wie in Vorlesung
	public int hash(final int tableSize)
	{
		char c1 = Name.charAt(0);
		char c2 = Name.charAt(1);

		int h1 = c1 - '0';
		int h2 = c2 - '0';
		int h = (h1 + h2) % tableSize;

		// Debug-Ausgabe zu Testzwecken
		// System.out.println("Name:" + Name + " Hashwert:" + h);

		return h;
	}

	public boolean equals(Object o)
	{
		// In diesem Beispiel nur Professor-Objekte zulassen
		if (!(o instanceof Professor))
			return false;

		final Professor p = (Professor)o;

		return ((p.Name).equals(this.Name) && (p.Hausruf == this.Hausruf));
	}

	public String toString()
	{
		return Name;
	}
}
