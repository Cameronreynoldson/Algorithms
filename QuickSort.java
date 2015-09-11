import java.util.Arrays;
import java.util.Random;

//couldn't get random to work for some reason?

public class QuickSort
{


	public static void main(String[] args)
	{
		//int[] array = {1,4,2,6,3,9,20,12,11};
		//quickSort(array,0,array.length-1);
		//System.out.println(Arrays.toString(array));
		for(int i = 0; i < 100000; ++i)
		{
			int[] array = generateRandomArray();
			test(array);
		}
	}


	public static void quickSort(int[] array, int low, int high)
	{
		int leftIndex = low; 
		int rightIndex = high;
		//Random random = new Random();
		//int randomPivot = random.nextInt(high-low)+low;
		int pivotIndex = (high+low)/2;
		int pivot = array[pivotIndex];

		while(leftIndex <= rightIndex)
		{
			while(array[leftIndex] < pivot)
			{
				leftIndex++;
			}
			
			while(array[rightIndex] > pivot)
			{
				rightIndex--;
			}
			
			if(leftIndex <= rightIndex)
			{
				int temp = array[rightIndex];
				array[rightIndex] = array[leftIndex];
				array[leftIndex] = temp;
				rightIndex--;
				leftIndex++;
			}
		}
		
		if(leftIndex < high)
		{
			quickSort(array,leftIndex,high);
		}
		
		if(rightIndex > low)
		{
			quickSort(array,low,rightIndex);
		}

	}
	
	
	public static int[] generateRandomArray()
	{
		int size = (int) (Math.random()*100);
		int[] array = new int[size];
		for(int i = 0; i < size; ++i)
		{
			array[i] = (int) Math.random()*10;
		}
		return array;
	}
	
	public static void test(int[] array)
	{
			if(array.length-1 >= 0){
			quickSort(array,0,array.length-1);
			System.out.println(checkSort(array));
			}
		
	}
	
	public static boolean checkSort(int[] array)
	{
		for(int i = 1; i < array.length; ++i)
		{
			if(array[i] > array[i-1])
			{
				return false;
			}
		}
		return true;
	}
}