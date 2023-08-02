package sorting;

/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from the unsorted part and putting it at the beginning.

In every iteration of the selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 */

/*
* 64   	   25   	   12   	   22   	   11
* 11   	   25   	   12   	   22   	   64
*
* 11   	   25   	   12   	   22   	   64
* 11   	   12   	   25   	   22   	   64
*
* 11   	   12   	   25   	   22   	   64
* 11   	   12   	   22   	   25   	   64
*
* 11   	   12   	   22   	   25   	   64
 */

public class SelectionSort {
    void selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
