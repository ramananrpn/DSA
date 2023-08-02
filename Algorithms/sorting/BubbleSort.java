package sorting;
/*
* Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
* This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.
* */

/*
* How does Bubble Sort Work?
Input: arr[] = {5, 1, 4, 2, 8}

First Pass:

Bubble sort starts with very first two elements, comparing them to check which one is greater.
( '5 1' 4 2 8 ) –> ( '1 5' 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 '5 4' 2 8 ) –>  ( 1 '4 5' 2 8 ), Swap since 5 > 4
( 1 4 '5 2' 8 ) –>  ( 1 4 '2 5' 8 ), Swap since 5 > 2
( 1 4 2 '5 8' ) –> ( 1 4 2 '5 8' ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
Second Pass:

Now, during second iteration it should look like this:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Third Pass:

Now, the array is already sorted, but our algorithm does not know if it is completed.
The algorithm needs one whole pass without any swap to know it is sorted.
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
*
*/

// TAGS : sorting , bubble_sort

public class BubbleSort {
    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
}

// Time Complexity: O(N2)
// Space: O(1)
