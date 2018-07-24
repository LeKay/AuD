package Blatt8;

public class HeapSort
{
	// Versickere das Element mit Index zuversickern in dem Teilfeld von Index links bis einschließlich Index rechts
	public static void versickere(int[] array, int zuversickern, final int links, final int rechts)
	{
		// Im Gegensatz zur Vorlesung benötigt diese Methode drei Parameter, da der zu sortierende Bereich
		// nicht bei 0, sondern bei links anfängt. Linkes Kind von Knoten x: (x-links)*2+links+1
		int sickender = array[zuversickern];
		int x  = zuversickern;
		int kind = (x-links)*2+links+1;
		while(kind <= rechts){
			if(kind+1 <= rechts && array[kind] < array[kind+1])
				kind++;
			if(sickender < array[kind]) {
				array[x] = array[kind];
				x = kind;
				kind = (x-links)*2+links+1;
			}
			else {
				break;
			}
		}
		array[x] = sickender;
	}

	public static void heapsort(int[] array, final int links, final int rechts)
	{
		// Wandle Array in einen Heap
		for(int i = (links+rechts-1)/2; i >= links; i--) {
			versickere(array, i, links, rechts);
		}
		// Phase 2
		for(int i = rechts; i >= links; i--) {
			int x = array[links];
			array[links] = array[i];
			array[i] = x;
			versickere(array, links, links, i-1);
		}
	}
}