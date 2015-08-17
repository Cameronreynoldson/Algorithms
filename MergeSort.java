import java.util.Arrays;
public class MergeSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] {5, 3, 2, 16, 7};
		mergeSort(array);
		for (int i = 0; i < array.length; ++i)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] array)
	{
		if (array.length == 1)
		{
			return;
		}

		int size = array.length;
		int leftSize = size / 2;
		int rightSize = size - leftSize;

		int[] leftHalf = new int[leftSize];
		int[] rightHalf = new int[rightSize];

		// Copy over to halves
		for (int i = 0; i < leftHalf.length; ++i)
		{
			leftHalf[i] = array[i];
		}

		for (int i = 0; i < rightHalf.length; ++i)
		{
			rightHalf[i] = array[leftSize + i];
	//		System.out.println("right half of "+i+" = "+rightHalf[i]);
		}

		// Sort halves recursively
		mergeSort(leftHalf);
		mergeSort(rightHalf);

		// Merge two sorted halves into bigger half
	//	System.out.println("Right half = "+Arrays.toString(rightHalf));
		merge(leftHalf, rightHalf, array);
	}

	public static void merge(int[] l, int[] r, int[] a)
	{
		System.out.println("left array = "+Arrays.toString(l)+" right array = "+Arrays.toString(r));
		int lIndex = 0;
		int rIndex = 0;
		int index = 0;

		// Store smallest elements until one runs out of room
		while (lIndex < l.length && rIndex < r.length)
		{
			if (l[lIndex] < r[rIndex])
			{
				a[index] = l[lIndex];

				++index;
				++lIndex;
			}
			else
			{
				a[index] = r[rIndex];

				++index;
				++rIndex;
			}
		}

		// Store the remaining elements into the bigger
		// array.

		// Only one of these loops will run because of the
		// termination conditions of the previous loop.
		while (lIndex < l.length)
		{
			a[index] = l[lIndex];

			++index;
			++lIndex;
		}

		while (rIndex < r.length)
		{
			a[index] = r[rIndex];

			++index;
			++rIndex;
		}
	}
}