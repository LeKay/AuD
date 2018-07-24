package Blatt8;

public class QuickSort
{
	public static void quicksort(int[] array, final int links, final int rechts)
	{
		int li = links;
		int re = rechts;
		int vergl = array[(links + rechts)/2];
		while(li <= re){
			while(array[li] < vergl)
				li++;
			while(array[re] > vergl)
				re--;
			if(li <= re) {
				int x = array[li];
				array[li] = array[re];
				array[re] = x;
				li++;
				re--;
			}
		}
		if(links < re)
			quicksort(array,links,re);
		if(rechts > li)
			quicksort(array,li,rechts);
	}
}