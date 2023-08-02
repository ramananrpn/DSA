package sorting;

/*
* Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
*
* Start from index 1 (i=1) and store value in key (int key = arr[i])
* Repeat Comparing with previous element (j=i-1) if the previous element is greater than key until index 0 (while (j >= 0 && arr[j] > key))
* If the comparing element is greater than key, then move it to the right (j+1)
* when comparing element is not greater than key or j reaches 0 then move the key to j+1 positiion
*
*
* So start picking the element from index 1, compare it with previous values and insert at right position
* At the end array will be sorted
* */
public class InsertionSort {
    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
