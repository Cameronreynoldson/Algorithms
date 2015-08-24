import java.util.*; 
//Quickselect algorithm
//Finds the kth smallest element in an unordered array in average O(n) time (worst case O(n^2)) and O(1) space

public class Quickselect
{
	public static void main(String[] args)
	{
		int[] array = {1,2,5,3,7,88};
		int val = quickselect(array,3);
		System.out.println(val);
	}


	public static int quickselect(int[] array, int k)
	{
		int left = 0; 
		int right = array.length-1;
		Random r = new Random();

		while(left <= right)
		{
			int pivotIndex = partition(array,left,right,r.nextInt(right-left+1)+left);

			if(pivotIndex == k-1)
			{
				return array[pivotIndex];
			}

			else if(pivotIndex < k-1)
			{
				left = pivotIndex+1;
			}

			else
			{
				right = pivotIndex-1; 
			}
		} 

		return -1;
	}


	public static int partition(int[] array, int left, int right, int pivot)
	{
		int pivotVal = array[pivot];
		swap(array,pivot,right);
		int storeIndex = left; 

		for(int i = left; i < right; ++i)
		{
			if(array[i] <= pivotVal)
			{
				swap(array,i,storeIndex);
				storeIndex++;
			}
		}

		swap(array,right,storeIndex);

		return storeIndex; 
	}

	public static void swap(int[] array, int i1, int i2)
	{
		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp; 
	}
}
