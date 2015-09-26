import java.util.*;

public class CountingSort
{
	public static void main(String[] args)
	{
		int[] a = {2,1,4,6,0,-5};
		countingSort(a,-5,6);
		System.out.println(Arrays.toString(a));
	}

	private static void countingSort(int[] a, int low, int high)
	{
		int[] count = new int[high-low+1];
		for(int i = 0; i < a.length; ++i)
		{
			count[a[i]-low]++;
		}

		int[] result = new int[a.length];
		int index = 0; 

		for(int i = 0; i < count.length; ++i)
		{
			while(count[i] > 0 && index < result.length)
			{
				a[index] = i + low; 
				count[i]--;
				index++;
			}
		}
	}
}
