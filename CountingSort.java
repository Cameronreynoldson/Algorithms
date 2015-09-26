import java.util.*;

public class CountingSort
{
	public static void main(String[] args)
	{
		int[] a = {2,1,4,6,0,-5};
		countingSort(a,-5,6);
	}

	private static void countingSort(int[] a, int low, int high)
	{
		int[] count = new int[high-low+1];
		for(int i = 0; i < a.length; ++i)
		{
			count[a[i]-low]++;
		}

		int[] result = new int[a.length];
		System.out.println(Arrays.toString(count));
		int index = 0; 

		for(int i = 0; i < result.length; ++i)
		{
			while(count[i] > 0 && index < result.length)
			{
				System.out.println(i+" "+low);
				result[index] = i + low; 
				count[i]--;
				index++;
			}
		}

		System.out.println(Arrays.toString(result));
	}
}
